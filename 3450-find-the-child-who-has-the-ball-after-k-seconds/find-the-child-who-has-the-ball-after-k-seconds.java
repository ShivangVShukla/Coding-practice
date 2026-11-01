class Solution {
    public int numberOfChild(int n, int k) {
        int comp=k/(n-1);
        int rem=k%(n-1);
        int ans=0;
        if(comp%2!=0) ans=n-rem-1;
        else ans=rem;
        return ans;
    }
}