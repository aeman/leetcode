/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int m, n;

    public int numEnclaves(int[][] grid) {
        int numIslands = 0;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][n - 1] == 1) dfs(grid, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[m - 1][i] == 1) dfs(grid, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) numIslands++;
            }
        }

        return numIslands;
    }

    public void dfs(int[][] grid, int row, int col) {
        // 陆地沉入海底
        grid[row][col] = 0;

        for (int[] dir : dirs) {
            int row2 = row + dir[0], col2 = col + dir[1];
            // 超出边界或者不是陆地，跳过
            if (row2 < 0 || row2 > m - 1 || col2 < 0 || col2 > n - 1 || grid[row2][col2] != 1) continue;
            dfs(grid, row2, col2);
        }
    }
}
// @lc code=end
