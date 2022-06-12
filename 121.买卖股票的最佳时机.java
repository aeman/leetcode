/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        // 1.greedy
        // int minPrice = Integer.MAX_VALUE;
        // for (int i = 0; i < prices.length; i++) {
        //     minPrice = Math.min(minPrice, prices[i]);
        //     ans = Math.max(ans, prices[i] - minPrice);
        // }

        // 2.dp
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (ans < (prices[i] - bought)) {
                    ans = prices[i] - bought;
                }
            } else {
                bought = prices[i];
            }
        }
        
        return ans;
    }
}
// @lc code=end
