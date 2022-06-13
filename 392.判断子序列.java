/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();

        // 1.greedy
        // int i = 0, j = 0;
        // while (i < m && j < n) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        //     j++;
        // }
        // return i == s.length();

        // 2.dp
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n] == s.length() ? true : false;
    }
}
// @lc code=end

