/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        // 1.中心扩展法
        // for (int i = 0; i < n; i++) {
        //     ans += count(s, i, i);
        //     ans += count(s, i, i + 1);
        // }

        // 2.dp
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    // 从中心向两边扩展
    private int count(String s, int left, int right) {
        int ret = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ret++;
            left--;
            right++;
        }
        return ret;
    }
}
// @lc code=end
