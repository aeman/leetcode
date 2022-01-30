/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int i = 0, j = matrix[0].length - 1;
        // while (i < matrix.length && j >= 0) {
        //     if (matrix[i][j] == target) {
        //         return true;
        //     } else if (matrix[i][j] > target) {
        //         j--;
        //     } else {
        //         i++;
        //     }
        // }
        // return false;

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // 这句很关键，找到矩阵的中间位置
            int midValue = matrix[mid / n][mid %  n];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                high = high - 1;
            } else {
                low = low + 1;
            }
        }
        return false;
    }
}
// @lc code=end

