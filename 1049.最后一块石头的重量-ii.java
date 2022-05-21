/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones)
            sum += stone;

        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stone)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stone] + stone);
            }
        }

        return Math.abs(sum - dp[n][target] - dp[n][target]);
    }
}
// @lc code=end
