import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1289 lang=java
 *
 * [1289] 下降路径最小和  II
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int val = grid[i][j];
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        // 和上一行比的最小值
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + val);
                    }
                }
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
// @lc code=end

