/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 到达终点
 */

// @lc code=start
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;
        }
        if (tx < sx || ty < sy)
            return false;
        return sx == tx ? (ty - sy) % tx == 0 : (tx - sx) % ty == 0;
    }
}
// @lc code=end
