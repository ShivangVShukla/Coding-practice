class Solution {
    public int countEven(int num) {
        int cnt=0;
        for(int i=1;i<=num;i++){
            int sum=0;
            int temp=i;
            while(temp>0){
                int digit=temp%10;
                sum+=digit;
                temp/=10;
            }
            if(sum%2==0) cnt++;
        }
        return cnt;
    }
}