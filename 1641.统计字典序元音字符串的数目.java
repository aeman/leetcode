/*
 * @lc app=leetcode.cn id=1641 lang=java
 *
 * [1641] 统计字典序元音字符串的数目
 */

// @lc code=start
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // a
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            // e
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            // i
            dp[i][2] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            // o
            dp[i][3] = dp[i - 1][3] + dp[i - 1][4];
            // u
            dp[i][4] = dp[i - 1][4];
        }
        int ans = 0;
        for (int j = 0; j < 5; j++) {
            ans += dp[n][j];
        }
        return ans;
    }
}
// @lc code=end
