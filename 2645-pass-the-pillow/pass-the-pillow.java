class Solution {
    public int passThePillow(int n, int time) {
        int comp=time/(n-1);
        int rem=time%(n-1);
        int ans=0;
        if(comp%2!=0) ans=n-rem;
        else ans=rem+1;
        return ans;
    }
}