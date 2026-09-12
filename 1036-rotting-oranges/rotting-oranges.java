class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        if (cnt == 0)
            return 0;
        int time = 0;
        while (cnt > 0) {
            int[][] temp = new int[grid.length][grid[0].length];
            boolean changed = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (j > 0 && grid[i][j - 1] == 1) {
                            temp[i][j - 1] = 1;
                        }
                        if (i > 0 && grid[i - 1][j] == 1) {
                           temp[i - 1][j] = 1;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            temp[i + 1][j] = 1;
                        }
                        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                            temp[i][j + 1] = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (temp[i][j] == 1) {
                        grid[i][j] = 2;
                        cnt--;
                        changed = true;
                    }
                }
            }
            if (!changed)
                return -1;
            time++;
        }
        return time;
    }
}