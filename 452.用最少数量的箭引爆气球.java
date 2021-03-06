import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // a[1] - b[1] 整型越界
        int ans = 0, right = 0;
        for (int i = 0; i < points.length; i ++) {
            if (ans == 0 || points[i][0] > right) {
                ans ++;
                right = points[i][1];
            }
        }
        return ans;
    }
}
// @lc code=end
