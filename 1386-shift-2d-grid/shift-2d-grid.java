class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k = k % (grid.length * grid[0].length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        Collections.reverse(list);
        reverse(list, 0, k - 1);
        reverse(list, k, list.size() - 1);
        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = list.get(idx++);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                rowList.add(grid[i][j]);
            }
            result.add(rowList);
        }
        return result;
    }
    void reverse(List<Integer> list, int start, int end) {
        while (start <= end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}