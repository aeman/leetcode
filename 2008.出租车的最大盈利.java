import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2008 lang=java
 *
 * [2008] 出租车的最大盈利
 */

// @lc code=start
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int index = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (index < rides.length && rides[index][1] <= i) {
                dp[i] = Math.max(dp[i], dp[rides[index][0]] + rides[index][1] - rides[index][0] + rides[index][2]);
                index++;
            }
        }
        return dp[n];
    }
}
// @lc code=end
