class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) >= 2) {
                    cnt++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}