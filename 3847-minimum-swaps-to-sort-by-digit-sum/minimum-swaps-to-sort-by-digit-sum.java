
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int x = nums[i], sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == arr[i][0]) {
                continue;
            }

            int j = map.get(arr[i][0]);

            map.put(nums[i], j);
            map.put(arr[i][0], i);

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            cnt++;
        }
        return cnt;
    }
}
