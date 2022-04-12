/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int count = 1, last = 0;
        for (char c : s.toCharArray()) {
            last += widths[c - 'a'];
            if (last > 100) {
                count++;
                last = widths[c - 'a'];
            }
        }
        return new int[] { count, last };
    }
}
// @lc code=end
