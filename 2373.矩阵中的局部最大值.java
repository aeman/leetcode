/*
 * @lc app=leetcode.cn id=2373 lang=java
 *
 * [2373] 矩阵中的局部最大值
 */

// @lc code=start
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int k2 = j - 1; k2 <= j + 1; k2++) {
                        max = Math.max(max, grid[k][k2]);
                    }
                }
                ans[i - 1][j - 1] = max;
            }
        }
        return ans;
    }
}
// @lc code=end
