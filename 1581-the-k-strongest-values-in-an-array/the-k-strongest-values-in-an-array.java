import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int median = arr[(n - 1) / 2];

        int[] result = new int[k];
        int left = 0;
        int right = n - 1;
        int idx = 0;

        while (idx < k) {
            int diffLeft = Math.abs(arr[left] - median);
            int diffRight = Math.abs(arr[right] - median);

            if (diffRight > diffLeft || (diffRight == diffLeft && arr[right] >= arr[left])) {
                result[idx++] = arr[right];
                right--;
            } else {
                result[idx++] = arr[left];
                left++;
            }
        }

        return result;
    }
}