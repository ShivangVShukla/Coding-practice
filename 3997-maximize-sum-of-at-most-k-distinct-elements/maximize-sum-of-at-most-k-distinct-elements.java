class Solution {
    public int[] maxKDistinct(int[] nums,int k) {
        int[] arr=new int[k];
        int n=nums.length;
        Arrays.sort(nums);
        int j=0;
        for(int i=n-1;i>=0 && j<k;i--){
            if(!isPresent(arr,nums[i])){
                arr[j]=nums[i];
                j++;
            }
        }
        return Arrays.copyOf(arr,j);
    }
    boolean isPresent(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return true;
        }
        return false;
    }
}