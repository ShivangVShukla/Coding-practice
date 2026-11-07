class Solution {
    public int calculateScore(int a, int b) {
        int bina =bin(a);
        int cnt1=count1(bina);
        int binb =bin(b);
        int cnt2=count1(binb);
        if(cnt1>=cnt2) return cnt1*cnt2;
        return cnt2/cnt1;
    }
    private int bin(int num){
        String s="";
        while(num>0){
            s=(num%2)+s;
            num=num/2;
        }
        return Integer.parseInt(s);
    }
    private int count1(int num){
        int cnt=0;
        String str=String.valueOf(num);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') cnt++;
        }
        return cnt;
    }
}