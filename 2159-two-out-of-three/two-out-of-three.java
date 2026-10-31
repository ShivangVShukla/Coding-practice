class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> list=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        HashSet<Integer> set3=new HashSet<>();
        for(int num:nums1) set1.add(num);
        for(int num:nums2) set2.add(num);
        for(int num:nums3) set3.add(num);
        for(int num: set1){
            if(set2.contains(num) || set3.contains(num)) list.add(num);
        }
        for(int num:set2){
            if(set1.contains(num) || set3.contains(num)) list.add(num);
        }
        return new ArrayList<>(list);
    }
}