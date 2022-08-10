/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int n = s.length, mid = s.length / 2;

        for (int i = 0; i < mid; i++) {
            char temp = s[n - 1 - i];
            s[n - 1 - i] = s[i];
            s[i] = temp;
        }
    }
}
// @lc code=end

