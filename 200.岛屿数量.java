/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, nr, nc);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int r, int c, int nr, int nc) {
        grid[r][c] = '0';
        
        if (r - 1 >= 0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c, nr, nc);
        if (r + 1 < nr && grid[r + 1][c] == '1') dfs(grid, r + 1, c, nr, nc);
        if (c - 1 >= 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1, nr, nc);
        if (c + 1 < nc && grid[r][c + 1] == '1') dfs(grid, r, c + 1, nr, nc);
    }
}
// @lc code=end

