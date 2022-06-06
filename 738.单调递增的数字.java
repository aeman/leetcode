/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] cs = s.toCharArray();

        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (cs[i] > cs[i + 1]) {
                cs[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            cs[i] = '9';
        }

        return Integer.parseInt(String.valueOf(cs));
    }
}
// @lc code=end
