class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int curr = 0;
        int count = 0;
        for(int i = 0; i < k; i++){
            curr += arr[i];
        }
        if((curr/k) >= threshold){
            count++;
        }
        int left = 0; 
        int right = k;
        while(right < n){
            curr -= arr[left];
            curr += arr[right];
            if((curr / k) >= threshold){
                count++;
            }
            left++;
            right++;
        }
        return count;
    }
}