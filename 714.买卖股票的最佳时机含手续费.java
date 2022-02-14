import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0] - fee, sell = 0;

        for (int i = 1; i < n; i++) {
            int buy2 = Math.max(buy, sell - prices[i] - fee);
            int sell2 = Math.max(sell, buy + prices[i]);
            buy = buy2;
            sell = sell2;
        }

        return sell;
    }
}
// @lc code=end
