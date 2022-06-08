/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        // 1.dp
        // if (n == 0) return 0;

        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;

        // for (int i = 2; i <= n; i++) {
        //     dp[i] = dp[i - 2] + dp[i - 1];
        // }

        // return dp[n];

        // 2.递归
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        if (n == 0 || n == 1) return n;
        
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}
// @lc code=end
