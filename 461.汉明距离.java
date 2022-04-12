/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // return Integer.bitCount(x ^ y);
        int s = x ^ y, ans = 0;
        while (s != 0) {
            ans += s & 1;
            s = s >> 1;
        }
        return ans;
    }
}
// @lc code=end

