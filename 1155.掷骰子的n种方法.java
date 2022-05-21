/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int point = 1; point <= k; point++) {
                    if (j >= point) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - point]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
// @lc code=end
