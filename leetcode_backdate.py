import os
import requests
import json
import subprocess
from datetime import datetime
import time

# TOKENS (Keep them here until code runs successfully)
LEETCODE_SESSION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiMjEyNDU1MjQiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJhbGxhdXRoLmFjY291bnQuYXV0aF9iYWNrZW5kcy5BdXRoZW50aWNhdGlvbkJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiIzODE2ZjhlZTM2NmY0MWI0NjMzNmQ5NWViMjdhMzY0MmNlYTQ4MjdjNmJhYWE5NjhmMDNiNTliYmJmMTZjNDY4Iiwic2Vzc2lvbl91dWlkIjoiMzdjMDU5OTgiLCJpZCI6MjEyNDU1MjQsImVtYWlsIjoic2hpdmFuZ3JlY292ZXJ5MjAwN0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6IlNoaXZhbmdWU2h1a2xhIiwidXNlcl9zbHVnIjoiU2hpdmFuZ1ZTaHVrbGEiLCJhdmF0YXIiOiJodHRwczovL2Fzc2V0cy5sZWV0Y29kZS5jb20vdXNlcnMvU2hpdmFuZ1ZTaHVrbGEvYXZhdGFyXzE3NzMyMzE5MTMucG5nIiwicmVmcmVzaGVkX2F0IjoxNzg2MDI4ODIzLCJpcCI6IjI0MDk6NDA5MDoyMDA1Ojc4MGQ6YTU2YzoyMzE4OmM5NmQ6OGIxNyIsImlkZW50aXR5IjoiNjk2N2VjNzI2MWIzY2JlNmE5MWQ3OThjNmI5NTFjNjAiLCJkZXZpY2Vfd2l0aF9pcCI6WyIyMDRiYzgyMDc4MmE5NDdhMzNiZDUwYWZiYmJkNWNjOSIsIjI0MDk6NDA5MDoyMDA1Ojc4MGQ6YTU2YzoyMzE4OmM5NmQ6OGIxNyJdfQ.xJmDeAxoJUMV1k9f1ZszmktnNkVH0-fTqkQdHce5QCA"
CSRF_TOKEN = "u30qjlwbxwPY98CfhA7kAwtsGXAKjlvn"

headers = {
    'content-type': 'application/json',
    'cookie': f'LEETCODE_SESSION={LEETCODE_SESSION}; csrftoken={CSRF_TOKEN}',
    'x-csrftoken': CSRF_TOKEN,
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'
}

query = """
query userSubmissions($offset: Int!, $limit: Int!) {
    submissionList(offset: $offset, limit: $limit) {
        submissions {
            id
            title
            titleSlug
            timestamp
            statusDisplay
            lang
        }
    }
}
"""

all_accepted_subs = []
offset = 0
limit = 100  # Fetching 100 at a time for safety
has_more = True

print("Connecting to LeetCode API & Scanning all history pages...")

while has_more:
    print(f"Fetching submissions starting from index {offset}...")
    response = requests.post('https://leetcode.com/graphql', json={'query': query, 'variables': {'offset': offset, 'limit': limit}}, headers=headers)
    
    if response.status_code != 200 or "submissionList" not in response.json().get('data', {}):
        print("Error connecting to API or tokens expired.")
        break
        
    submissions = response.json()['data']['submissionList']['submissions']
    
    if not submissions:
        has_more = False
        break
        
    for sub in submissions:
        if sub['statusDisplay'] == 'Accepted':
            all_accepted_subs.append(sub)
            
    offset += limit
    time.sleep(0.5) # Soft delay to prevent LeetCode rate limits

print(f"\nScan complete! Found a total of {len(all_accepted_subs)} Accepted solutions.")

# Deduplicate to avoid making repeated folders for same problem solved multiple times
unique_subs = {}
for sub in all_accepted_subs:
    if sub['titleSlug'] not in unique_subs:
        unique_subs[sub['titleSlug']] = sub

print(f"Processing {len(unique_subs)} unique problems for backdated sync...")

for slug, sub in unique_subs.items():
    title = sub['title']
    timestamp = int(sub['timestamp'])
    date_str = datetime.fromtimestamp(timestamp).strftime('%Y-%m-%d %H:%M:%S')
    
    os.makedirs(slug, exist_ok=True)
    file_path = os.path.join(slug, "solution.txt")
    with open(file_path, "w") as f:
        f.write(f"// Solved Leetcode Problem: {title}\n// Language: {sub['lang']}\n")
    
    subprocess.run(["git", "add", "."], check=True)
    env = os.environ.copy()
    env["GIT_AUTHOR_DATE"] = date_str
    env["GIT_COMMITTER_DATE"] = date_str
    subprocess.run(["git", "commit", "-m", f"Sync: {title} ({sub['lang']})"], env=env, stdout=subprocess.DEVNULL)

print("\n✅ Success! All historic problems committed backdated to their original days.")
