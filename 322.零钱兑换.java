/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;

        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0] = 0;

        // i代表钱数，从1元开始开始直到条件中的数量
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 这个条件满足，说明硬币coins[j]的面值可以进来凑数
                if (i - coins[j] >= 0 && memo[i - coins[j]] < min) {
                    // 抛开当前硬币的最小数量
                    min = memo[i - coins[j]] + 1;
                }
            }
            memo[i] = min;
        }

        // memo[amount]等于最大值说明无法兑换
        return (memo[amount] == Integer.MAX_VALUE) ? -1 : memo[amount];
    }
}
// @lc code=end

