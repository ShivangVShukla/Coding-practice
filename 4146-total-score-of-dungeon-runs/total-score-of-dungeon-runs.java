class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            damage[i] += damage[i - 1];
        }
        for (int i = 1; i < n; i++) {
            int boundary = find(damage, i, hp, requirement);

            ans += (i - boundary);
        }
        if (hp - damage[0] >= requirement[0]) ans++;
        return ans;
    }
    public int find(int damage[], int idx, int hp, int requirement[]){
        int low = 0, high = idx; int ans = idx;
        while (low <= high) {
            int mid = (low + high) / 2;
            long dmg = damage[idx] - (mid > 0 ? damage[mid - 1] : 0);
            if (hp - dmg >= requirement[idx]) {
                ans = mid-1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}