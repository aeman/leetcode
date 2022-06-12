/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int buy = -prices[0] - fee, sell = 0;

        // for (int i = 1; i < n; i++) {
        //     int buy2 = Math.max(buy, sell - prices[i] - fee);
        //     int sell2 = Math.max(sell, buy + prices[i]);
        //     buy = buy2;
        //     sell = sell2;
        // }

        // return sell;

        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];   //持有股票
        dp[0][1] = 0;            //不持有股票
            
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[n - 1][1];
    }
}
// @lc code=end
