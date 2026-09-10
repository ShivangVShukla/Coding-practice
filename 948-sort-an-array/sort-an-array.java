class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
    public void merge(int[] nums,int si,int ei){
        if(si>= ei) return;
        int mid=si+(ei-si)/2;
        merge(nums,si,mid);
        merge(nums,mid+1,ei);
        mergeSort(nums,mid,si,ei);
    }
    public void mergeSort(int[] nums,int mid,int si, int ei){
        int[] temp =new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k= 0;
        while(i<=mid && j<=ei){
            if(nums[i] <=nums[j]){
                temp[k]=nums[i];
                i++;
            }else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=ei) temp[k++]=nums[j++];
        for(int a=0;a<temp.length;a++){
            nums[si+a]=temp[a];
        }
    }
}