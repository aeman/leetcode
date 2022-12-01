/*
 * @lc app=leetcode.cn id=1779 lang=java
 *
 * [1779] 找到最近的有相同 X 或 Y 坐标的点
 */

// @lc code=start
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, minD = Integer.MAX_VALUE;
        for (int i = points.length - 1; i >= 0; i--) {
            int[] t = points[i];
            if (x == t[0] || y == t[1]) {
                int d = Math.abs(x - t[0]) + Math.abs(y - t[1]);
                if (d <= minD) {
                    ans = i;
                    minD = d;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

