/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n + 1][amount + 1];
        // dp[0][0] = 1;

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j <= amount; j++) {
        //         for (int k = 0; k * coins[i - 1] <= j; k++) {
        //             dp[i][j] = dp[i][j] + dp[i - 1][j - coins[i - 1] * k];
        //         }
        //     }
        // }

        // return dp[n][amount];

        // 一维优化
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }
}
// @lc code=end
