class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=2;i<=n/2;i++){
            if(isPrime(i) && isPrime(n-i)){
                List<Integer> temp =new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                if(!temp.isEmpty()) list.add(temp);
            }
        }
        return list;
    }
    public boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
    }
}