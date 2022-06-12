/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];

        // 1.dp
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // 2.完全背包
        dp[0] = 1;
        int m = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }
}
// @lc code=end
