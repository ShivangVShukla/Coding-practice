class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        int ans=0;
        for(int i=0;i<chalk.length;i++){
            sum+=chalk[i];
        }
        k%=sum;
        for(int i=0;i<chalk.length;i++){
            if(chalk[i]>k){
                ans=i;
                break;
            }
            else k=k-chalk[i];
        }
        return ans;
    }
}