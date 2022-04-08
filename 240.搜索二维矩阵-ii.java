/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1.暴力搜索
        // int m = matrix.length, n = matrix[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == target) return true;
        //     }
        // }
        // return false;

        // 2.二分查找
        for (int[] row : matrix) {
            int pos = search(row, target);
            if (pos >= 0) return true;
        }
        return false;
    }

    private int search(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

