/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class Solution {
    public int maxScore(String s) {
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') right++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
}
// @lc code=end

