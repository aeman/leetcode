/*
 * @lc app=leetcode.cn id=1828 lang=java
 *
 * [1828] 统计一个圆中点的数目
 */

// @lc code=start
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = points.length, n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            for (int j = 0; j < m; j++) {
                int pX = points[j][0], pY = points[j][1];
                if ((x - pX) * (x - pX) + (y - pY) * (y - pY) <= r * r) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

