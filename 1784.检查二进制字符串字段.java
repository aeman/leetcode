/*
 * @lc app=leetcode.cn id=1784 lang=java
 *
 * [1784] 检查二进制字符串字段
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        String[] split = s.split("0");
        int count = 0;
        for (String s1 : split) {
            if (s1.length() > 0) count++;
        }
        return count <= 1;
    }
}
// @lc code=end

