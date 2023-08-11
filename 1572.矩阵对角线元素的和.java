/*
 * @lc app=leetcode.cn id=1572 lang=java
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (j != i) sum += mat[i][j];
            j--;
        }
        return sum;
    }
}
// @lc code=end

