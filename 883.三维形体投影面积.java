/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, xy = 0, yz = 0, zx = 0;

        for (int i = 0; i < n; i++) {
            int yzMax = 0, zxMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) xy++;   // 大于0，说明放有积木，面积+1
                yzMax = Math.max(yzMax, grid[i][j]); // 找出行里的最大值
                zxMax = Math.max(zxMax, grid[j][i]); // 找出列里的最大值
            }
            yz += yzMax;
            zx += zxMax;
        }

        return xy + yz + zx;
    }
}
// @lc code=end

