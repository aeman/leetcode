/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0], sell = 0, lock = 0;

        for (int i = 1; i < n; i++) {
            int buy2 = Math.max(buy, lock - prices[i]);
            int sell2 = Math.max(sell, buy + prices[i]);
            lock = sell;
            buy = buy2;
            sell = sell2;
        }

        return sell;
    }
}
// @lc code=end

