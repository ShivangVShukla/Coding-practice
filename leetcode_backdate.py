import os
import requests
import json
import subprocess
from datetime import datetime

# HARDCODED TOKENS (No terminal export needed)
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

print("Connecting to LeetCode API...")
response = requests.post('https://leetcode.com/graphql', json={'query': query, 'variables': {'offset': 0, 'limit': 200}}, headers=headers)

if response.status_code != 200 or "submissionList" not in response.json().get('data', {}):
    print("Error: LeetCode session or CSRF token incorrect!")
    exit()

submissions = response.json()['data']['submissionList']['submissions']
accepted_subs = [s for s in submissions if s['statusDisplay'] == 'Accepted']

print(f"Found {len(accepted_subs)} accepted problems. Starting backdated sync...")

for sub in accepted_subs:
    title = sub['title']
    slug = sub['titleSlug']
    timestamp = int(sub['timestamp'])
    date_str = datetime.fromtimestamp(timestamp).strftime('%Y-%m-%d %H:%M:%S')
    
    folder_name = slug
    os.makedirs(folder_name, exist_ok=True)
    
    file_path = os.path.join(folder_name, "solution.txt")
    with open(file_path, "w") as f:
        f.write(f"// Solved Leetcode Problem: {title}\n// Language: {sub['lang']}\n")
    
    subprocess.run(["git", "add", "."], check=True)
    env = os.environ.copy()
    env["GIT_AUTHOR_DATE"] = date_str
    env["GIT_COMMITTER_DATE"] = date_str
    subprocess.run(["git", "commit", "-m", f"Sync: {title} ({sub['lang']})"], env=env, stdout=subprocess.DEVNULL)

print("✅ Success! All previous problems committed backdated.")
print("Type 'git push origin main' to push them to your live GitHub profile.")
