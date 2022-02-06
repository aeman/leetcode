/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        //只有4块（倍数）石头的时候会输
        return n % 4 != 0;
    }
}
// @lc code=end

