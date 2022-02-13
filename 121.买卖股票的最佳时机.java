/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        // int bought = prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] > bought) {
        //         if (maxProfit < (prices[i] - bought)) {
        //             maxProfit = prices[i] - bought;
        //         }
        //     } else {
        //         bought = prices[i];
        //     }
        // }
        
        return maxProfit;
    }
}
// @lc code=end
