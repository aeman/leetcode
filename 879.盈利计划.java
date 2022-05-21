/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int gLen = group.length;
        int[][][] dp = new int[gLen + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= gLen; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < members) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            } 
        }

        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[gLen][j][minProfit]) % MOD;
        }
        return sum;
    }
}
// @lc code=end

