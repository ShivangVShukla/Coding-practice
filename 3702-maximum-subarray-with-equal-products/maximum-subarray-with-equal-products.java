class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int len = 1;
        for(int i=0;i<n;i++)
            {
                int  p = 1;
                for(int j=i;j<n;j++)
                    {
                        p *= nums[j];
                        if(gcd(nums,i,j,n) * lcm(nums,i,j,n) == p)
                        {
                            len = Math.max(j-i+1,len);
                        }
                    }
            }
        return len;
    }
    public int gcd(int nums[],int idx1,int idx2,int n)
    {
        for(int i=10;i>=1;i--)
            {
                boolean flag = true;
                for(int j=idx1;j<=idx2;j++)
                    {
                        if(nums[j]%i != 0)
                        {
                            flag = false;
                            break;
                        }
                    }
                if(flag)return i;
            }
        return 1;
    }
    public int lcm(int nums[],int idx1,int idx2,int n)
    {
        for(int i=1;i<=2520;i++)
            {
                boolean flag = true;
                for(int j=idx1;j<=idx2;j++)
                    {
                        if(i%nums[j]!=0)
                        {
                            flag = false;
                            break;
                        }
                    }
                if(flag)return i;
            }
        return 1;
    }
}