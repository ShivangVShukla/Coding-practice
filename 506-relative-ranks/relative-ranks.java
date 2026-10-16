class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] str=new String[score.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<score.length;i++){
            map.put(score[i],i);
        }
        Arrays.sort(score);
        for(int i=0;i<score.length;i++){
            int idx=map.get(score[i]);
            if(i==score.length-1) str[idx]="Gold Medal";
            else if(i==score.length-2) str[idx]="Silver Medal";
            else if(i==score.length-3) str[idx]="Bronze Medal";
            else str[idx]=String.valueOf(score.length-i);
        }
        return str;
    }
}