import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp1 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], true);
        }

        // 先计算子串（i-j）是否回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp1[i][j] = s.charAt(i) == s.charAt(j) && dp1[i + 1][j - 1];
            }
        }

        // 再找最少分割次数
        int[] dp2 = new int[n];
        Arrays.fill(dp2, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (dp1[0][i]) {
                dp2[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp1[j + 1][i]) {
                        dp2[i] = Math.min(dp2[i], dp2[j] + 1);
                    }
                }
            }
        }

        return dp2[n - 1];
    }
}
// @lc code=end

