import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=940 lang=java
 *
 * [940] 不同的子序列 II
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = (dp[i] + dp[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + dp[last[i]]) % MOD;
            }
        }
        return ans;
    }
}
// @lc code=end

