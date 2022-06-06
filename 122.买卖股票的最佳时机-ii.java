/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 1.greedy
        // int[] profit = new int[n];
        // for (int i = 1; i < n; i++) {
        //     profit[i] = prices[i] - prices[i - 1];
        // }
        // int ans = 0;
        // for (int p : profit) {
        //     ans += p > 0 ? p : 0;
        // }
        // return ans;

        // 2.dp
        int dp0 = 0, dp1 = -prices[0];  //dp0持有现金 dp1持有股票

        for (int i = 1; i < n; i++) {
            int dp00 = Math.max(dp0, dp1 + prices[i]);
            int dp11 = Math.max(dp1, dp0 - prices[i]);

            dp0 = dp00;
            dp1 = dp11;
        }

        return dp0;
    }
}
// @lc code=end

