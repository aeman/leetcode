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
            ans += count(s, i, i);
            ans += count(s, i, i + 1);
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
