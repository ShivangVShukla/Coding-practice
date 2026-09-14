class Solution {
    public String largestNumber(int[] nums) {
        String[] arr =new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));
        StringBuilder strb= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            strb.append(arr[i]);
        }
        if(strb.charAt(0)=='0') return "0";
        return strb.toString();
    }
}