/*
 * @lc app=leetcode.cn id=764 lang=java
 *
 * [764] 最大加号标志
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int ans = 0, grid[][] = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            grid[mines[i][0]][mines[i][1]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(grid, i, j, n));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int n) {
        if (grid[i][j] == 1) return 0;

        int k = 1;
        while (true) {
            if (i - k < 0 || i + k >= n || j - k < 0 || j + k >= n
                    || grid[i - k][j] == 1 || grid[i + k][j] == 1
                    || grid[i][j - k] == 1 || grid[i][j + k] == 1) {
                break;
            }

            k++;
        }
        return k;
    }
}
// @lc code=end
