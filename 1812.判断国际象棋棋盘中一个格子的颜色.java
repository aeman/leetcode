/*
 * @lc app=leetcode.cn id=1812 lang=java
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1, y = coordinates.charAt(1) - '0';
        return x % 2 != y % 2; 
    }
}
// @lc code=end

