import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
// @lc code=end

