/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];

        int index = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    ans[index] = mat[x][y];
                    index++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    ans[index] = mat[x][y];
                    index++;
                    x--;
                    y++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
