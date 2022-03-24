/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        int numIslands = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < nr; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, nr, nc);
            }
            if (grid[i][nc - 1] == 1) {
                dfs(grid, i, nc - 1, nr, nc);
            }
        }

        for (int i = 0; i < nc; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i, nr, nc);
            }
            if (grid[nr - 1][i] == 1) {
                dfs(grid, nr - 1, i, nr, nc);
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    public void dfs(int[][] grid, int r, int c, int nr, int nc) {
        grid[r][c] = 0;

        if (r - 1 >= 0 && grid[r - 1][c] == 1)
            dfs(grid, r - 1, c, nr, nc);
        if (r + 1 < nr && grid[r + 1][c] == 1)
            dfs(grid, r + 1, c, nr, nc);
        if (c - 1 >= 0 && grid[r][c - 1] == 1)
            dfs(grid, r, c - 1, nr, nc);
        if (c + 1 < nc && grid[r][c + 1] == 1)
            dfs(grid, r, c + 1, nr, nc);
    }
}
// @lc code=end

