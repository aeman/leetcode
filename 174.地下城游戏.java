import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 最后至少有一滴血
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minBlood = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minBlood - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
