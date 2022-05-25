import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];

        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            char curr = p.charAt(i);
            if (i > 0 && (curr - p.charAt(i-1) + 26) % 26 == 1) { // 前后两个字母相邻
                k++;
            } else {
                k = 1;
            }

            dp[curr- 'a'] = Math.max(dp[curr - 'a'], k);
        }

        return Arrays.stream(dp).sum();
    }
}
// @lc code=end

