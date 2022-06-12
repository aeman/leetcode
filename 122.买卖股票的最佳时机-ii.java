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
        // int ans = 0;
        // for (int i = 1; i < n; i++) {
        //     ans += Math.max(0, prices[i] - prices[i - 1]);
        // }
        // return ans;

        // 2.dp
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];   //持有股票
        dp[0][1] = 0;            //不持有股票
            
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
// @lc code=end

