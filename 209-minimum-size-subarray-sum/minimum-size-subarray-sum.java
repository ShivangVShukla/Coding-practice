class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=0;
        int sum=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                if(min==0) min=j-i+1;
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min;
    }
}