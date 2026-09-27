class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        int[] rem = new int[k];
        rem[0] = 1;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int r = sum % k;
            if(r < 0) r += k;
            cnt += rem[r];
            rem[r]++;
        }
        return cnt;
    }
}