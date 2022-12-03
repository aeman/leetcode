/*
 * @lc app=leetcode.cn id=1796 lang=java
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (d > first) {
                    second = first;
                    first = d;
                } else if (d < first && d > second) {
                    second = d;
                }
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
// @lc code=end
