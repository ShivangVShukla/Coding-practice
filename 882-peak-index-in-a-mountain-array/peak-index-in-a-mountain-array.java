class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;
        int low = 1;
        int high = arr.length-2;
        int idx = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]){
                idx = mid;
                break;
            }
            if(arr[mid-1] < arr[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return idx;
    }
}