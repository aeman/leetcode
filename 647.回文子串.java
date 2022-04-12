/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            int j = i - 1, k = i;
            while (k < n - 1 && s.charAt(k) == s.charAt(k + 1))
                k++;

            ans += (k - j) * (k - j + 1) / 2;
            i = k++;
            while (j >= 0 && k < n && s.charAt(k++) == s.charAt(j--))
                ans++;
        }

        return ans;
    }
}
// @lc code=end
