/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int[][] grid;
    private int m, n, ans = 0;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    backtrack(i, j, 0);
                }
            }
        }
        return ans;
    }

    private void backtrack(int i, int j, int gold) {
        gold += grid[i][j];
        ans = Math.max(ans, gold);

        int temp = grid[i][j];
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 0) {
                backtrack(x, y, gold);
            }
        }
        grid[i][j] = temp;
    }
}
// @lc code=end
