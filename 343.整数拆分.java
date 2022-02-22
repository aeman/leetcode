/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                maxVal = Math.max(maxVal, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = maxVal;
        }

        return dp[n];
    }
}
// @lc code=end
