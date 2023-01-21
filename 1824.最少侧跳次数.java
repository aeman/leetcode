/*
 * @lc app=leetcode.cn id=1824 lang=java
 *
 * [1824] 最少侧跳次数
 */

// @lc code=start
class Solution {
    private static final int INF = 0x3fffffff;
    
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[3];
        dp[0] = dp[2] = 1;
        for (int i = 1; i < n; i++) {
            int min = INF;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    dp[j] = INF;
                } else {
                    min = Math.min(min, dp[j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) continue;
                dp[j] = Math.min(dp[j], min + 1);
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
// @lc code=end

