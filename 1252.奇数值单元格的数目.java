/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        for (int[] index : indices) {
            int r = index[0], c = index[1];
            for (int i = 0; i < n; i++) {
                grid[r][i] += 1;
            }
            for (int i = 0; i < m; i++) {
                grid[i][c] += 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % 2 != 0)
                    ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
