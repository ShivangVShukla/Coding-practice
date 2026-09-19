class Solution {
    public long totalHours(int[] arr, int speed) {
        long hrs = 0;
        for (int i = 0; i < arr.length; i++) {
            hrs += (arr[i] + speed - 1) / speed; 
        }   
        return hrs;
    }
    public int minEatingSpeed(int[] arr, int k) {
        int low = 1;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high, arr[i]);
        }
        int ans = high; 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hrs = totalHours(arr, mid);   
            if (hrs <= k) {
                ans = mid;       
                high = mid - 1; 
            } else {
                low = mid + 1;   

            }
        }
        return ans;
    }
}