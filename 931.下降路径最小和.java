/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            memo[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    memo[i][j] = matrix[i][j] + Math.min(memo[i - 1][j], memo[i - 1][j + 1]);
                } else if (j == n - 1) {
                    memo[i][j] = matrix[i][j] + Math.min(memo[i - 1][j], memo[i - 1][j - 1]);
                } else {
                    memo[i][j] = matrix[i][j]
                            + Math.min(memo[i - 1][j], Math.min(memo[i - 1][j - 1], memo[i - 1][j + 1]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (memo[n - 1][i] < ans) {
                ans = memo[n - 1][i];
            }
        }
        return ans;
    }
}
// @lc code=end
