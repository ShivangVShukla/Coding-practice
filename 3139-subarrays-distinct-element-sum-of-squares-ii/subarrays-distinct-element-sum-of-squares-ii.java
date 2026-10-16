class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        int[] last = new int[n];
        java.util.Arrays.fill(last, -1);

        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int p = map.getOrDefault(x, -1) + 1;

            update(1, 0, n - 1, p, i, sum, sq, lazy, mod);
            ans = (ans + sq[1]) % mod;

            map.put(x, i);
        }

        return (int) ans;
    }

    void update(int node, int s, int e, int l, int r,
                long[] sum, long[] sq, long[] lazy, int mod) {
        if (l > e || r < s) return;

        if (l <= s && e <= r) {
            apply(node, s, e, 1, sum, sq, lazy, mod);
            return;
        }

        int mid = (s + e) / 2;
        push(node, s, mid, e, sum, sq, lazy, mod);

        update(node * 2, s, mid, l, r, sum, sq, lazy, mod);
        update(node * 2 + 1, mid + 1, e, l, r, sum, sq, lazy, mod);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % mod;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % mod;
    }

    void apply(int node, int s, int e, long v,
               long[] sum, long[] sq, long[] lazy, int mod) {
        long len = e - s + 1;

        sq[node] = (sq[node] + 2 * v % mod * sum[node] % mod
                    + v * v % mod * len % mod) % mod;

        sum[node] = (sum[node] + v * len) % mod;
        lazy[node] = (lazy[node] + v) % mod;
    }

    void push(int node, int s, int mid, int e,
              long[] sum, long[] sq, long[] lazy, int mod) {
        if (lazy[node] == 0 || s == e) return;

        apply(node * 2, s, mid, lazy[node], sum, sq, lazy, mod);
        apply(node * 2 + 1, mid + 1, e, lazy[node], sum, sq, lazy, mod);

        lazy[node] = 0;
    }
}