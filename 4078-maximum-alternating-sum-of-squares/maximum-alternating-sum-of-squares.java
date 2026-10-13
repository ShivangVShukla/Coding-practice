class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                arr[i]=nums[right];
                right--;
            }
            else{
                arr[i]=nums[left];
                left++;
            }
        }
        long sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum+= (long)arr[i]*arr[i];
        }
        long sub=0;
        for(int i=1;i<nums.length;i+=2){
            sub+=(long)arr[i]*arr[i];
        }
        return sum-sub;
    }
}