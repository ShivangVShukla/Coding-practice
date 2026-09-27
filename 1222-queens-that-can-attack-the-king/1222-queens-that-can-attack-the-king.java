class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            int x = queens[i][0];
            int y = queens[i][1];
            if (x == king[0] || y == king[1] ||
                Math.abs(x - king[0]) == Math.abs(y - king[1])) {
                int dx = Integer.compare(x, king[0]);
                int dy = Integer.compare(y, king[1]);
                int a = king[0] + dx;
                int b = king[1] + dy;
                boolean blocked = false;
                while (a != x || b != y) {
                    for (int j = 0; j < queens.length; j++) {
                        if (queens[j][0] == a && queens[j][1] == b) {
                            blocked = true;
                            break;
                        }
                    }
                    if (blocked) break;
                    a += dx;
                    b += dy;
                }
                if (!blocked) {
                    ans.add(Arrays.asList(x, y));
                }
            }
        }
        return ans;
    }
}