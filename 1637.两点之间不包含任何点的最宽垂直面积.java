import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1637 lang=java
 *
 * [1637] 两点之间不包含任何点的最宽垂直面积
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = points[i][0];
        }
        Arrays.sort(xs);
        int max = 0;
        for (int i = 1; i < n; i++) {
            int width = xs[i] - xs[i-1];
            max = Math.max(max, width);
        }
        return max;
    }
}
// @lc code=end

