import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int maxValue = values[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], values[i] - i + maxValue);
            maxValue = Math.max(maxValue, values[i] + i);
        }

        Arrays.sort(dp);
        return dp[n - 1];
    }
}
// @lc code=end
