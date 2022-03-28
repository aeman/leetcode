/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        // int prev = 2;
        // while (n != 0) {
        //     int cur = n % 2;
        //     if (cur == prev) {
        //         return false;
        //     }
        //     prev = cur;
        //     n /= 2;
        // }
        // return true;

        int a = n ^ n >> 1;
        return (a & (a + 1)) == 0;
    }
}
// @lc code=end

