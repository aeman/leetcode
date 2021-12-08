/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        String trim = s.trim();
        if (trim.length() == 0) return 0;

        char[] chars = trim.toCharArray();
        if (!Character.isDigit(chars[0]) && chars[0] != '+' && chars[0] != '-') return 0;

        int begin = 0;
        boolean symbol = true;
        if (chars[0] == '+') {
            begin = 1;
        } else if (chars[0] == '-') {
            begin = 1;
            symbol = false;
        }

        int ans = 0, last = 0;
        for (int i = begin; i < chars.length; i++) {
            last = ans;
            if (!Character.isDigit(chars[i])) break;
            ans = ans * 10 + (chars[i] - '0');
            if (ans / 10 != last) {
                return symbol ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return symbol ? ans : -ans;
    }
}
// @lc code=end

