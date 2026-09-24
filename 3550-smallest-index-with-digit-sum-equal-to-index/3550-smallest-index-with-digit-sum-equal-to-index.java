class Solution {
    public int smallestIndex(int[] nums) {
        int min =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                int digit = num%10;
                sum += digit;
                num/=10;
            }
            if((sum==i)&&(min==Integer.MIN_VALUE)) min =i;
            min=Math.min(min,i);
        }
        if(min==Integer.MIN_VALUE) return -1;
        return min;
    }
}