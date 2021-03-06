/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 1.greedy
        // int ans = 0;
        // int minPrice = Integer.MAX_VALUE;
        // for (int i = 0; i < n; i++) {
        //     minPrice = Math.min(minPrice, prices[i]);
        //     ans = Math.max(ans, prices[i] - minPrice);
        // }
        // return ans;

        // 2.dp
        int[][] dp = new int[n][2];
        dp[0][0] = 0;           //不持有股票
        dp[0][1] = -prices[0];  //持有股票
            
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
// @lc code=end
