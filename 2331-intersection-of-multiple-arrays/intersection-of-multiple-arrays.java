class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list=new ArrayList<>();
        int[] cnt=new int[1001];
        for(int[] arr:nums){
            for(int i: arr){
                cnt[i]++;
            }
        }
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==nums.length) list.add(i);
        }
        return list;
    }
}