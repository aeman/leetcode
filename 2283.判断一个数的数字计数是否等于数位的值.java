/*
 * @lc app=leetcode.cn id=2283 lang=java
 *
 * [2283] 判断一个数的数字计数是否等于数位的值
 */

// @lc code=start
class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c - '0' >= n) return false;
            map[c - '0'] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (map[i] != (num.charAt(i) - '0')) return false;
        }
        return true;
    }
}
// @lc code=end

