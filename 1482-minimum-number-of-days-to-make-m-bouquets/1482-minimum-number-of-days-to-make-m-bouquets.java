class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}