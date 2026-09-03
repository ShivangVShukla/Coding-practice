class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int x = nums[i];
            int tempMax = Math.max(x, Math.max(maxProd * x, minProd * x));
            int tempMin = Math.min(x, Math.min(maxProd * x, minProd * x));
            maxProd = tempMax;
            minProd = tempMin;
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}