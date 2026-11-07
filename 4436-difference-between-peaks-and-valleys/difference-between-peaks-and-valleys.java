class Solution {
    public int peakValleyDifference(int[] nums) {
        int n=nums.length;
        int peaksum=0;
        int valsum=0;
        // if(nums[0]>nums[1]) peaksum+=nums[0];
        // else valsum+=nums[0];
        // if(nums[n-1]>nums[n-2]) peaksum+=nums[n-1];
        // else valsum+=nums[n-1];
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
                peaksum+=nums[i];
            else if(nums[i]<nums[i-1] && nums[i]<nums[i+1])
                valsum+=nums[i];
        }
        return peaksum-valsum;
    }
}