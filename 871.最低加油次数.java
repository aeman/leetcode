/*
 * @lc app=leetcode.cn id=871 lang=java
 *
 * [871] 最低加油次数
 */

// @lc code=start
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target)
                return i;
        }
        return -1;
    }
}
// @lc code=end
