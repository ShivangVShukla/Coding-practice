class Solution {
    public boolean isGood(int[] nums) {
        if(nums.length==1) return false;
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        if(nums.length!=max+1) return false;
        if(nums[nums.length-1]!=nums[nums.length-2]) return false;
        for(int i=1;i<=nums.length-2;i++){
            if(nums[i-1]!=i) return false;
        }
        return true;
    }
}