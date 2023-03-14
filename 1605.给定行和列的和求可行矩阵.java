/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] 给定行和列的和求可行矩阵
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            int x = Math.min(rowSum[i], colSum[j]);
            res[i][j] = x;
            rowSum[i] -= x;
            colSum[j] -= x;
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return res;
    }
}
// @lc code=end

