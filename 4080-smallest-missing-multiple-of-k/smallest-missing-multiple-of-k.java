class Solution {
    public int missingMultiple(int[] nums, int k) {
        int cnt = 1;
        Arrays.sort(nums);
        for(int i = 0; i <nums.length;i++){
            if(k*cnt == nums[i]) cnt++;
        }
        return k*cnt;
    }
}