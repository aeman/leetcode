/*
 * @lc app=leetcode.cn id=1736 lang=java
 *
 * [1736] 替换隐藏数字得到的最晚时间
 */

// @lc code=start
class Solution {
    public String maximumTime(String time) {
        char[] cs = time.toCharArray();
        if (cs[0] == '?') {
            if (cs[1] >= '4' && cs[1] <= '9') {
                cs[0] = '1';
            } else {
                cs[0] = '2';
            }
        }
        if (cs[1] == '?') {
            if (cs[0] == '2') {
                cs[1] = '3';
            } else {
                cs[1] = '9';
            }
        }
        if (cs[3] == '?') {
            cs[3] = '5';
        }
        if (cs[4] == '?') {
            cs[4] = '9';
        }
        return new String(cs);
    }
}
// @lc code=end

