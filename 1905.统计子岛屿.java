/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    ans++;
                    dfs(grid2, i, j, m, n);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid2, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (grid2[i][j] == 0) return;

        grid2[i][j] = 0;
        dfs(grid2, i - 1, j, m, n);
        dfs(grid2, i + 1, j, m, n);
        dfs(grid2, i, j - 1, m, n);
        dfs(grid2, i, j + 1, m, n);
    }
}
// @lc code=end

