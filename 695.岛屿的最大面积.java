/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    private int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxIsland = Math.max(maxIsland, dfs(grid, i, j));
                }
            }
        }

        return maxIsland;
    }

    public int dfs(int[][] grid, int i, int j) {
        //水的点和地图外的点直接跳过
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;
        
        //当前点置0，避免重复计算
        grid[i][j] = 0;
        
        //四个方向延生
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);
    }
}
// @lc code=end

