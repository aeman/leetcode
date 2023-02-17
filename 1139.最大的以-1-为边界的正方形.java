/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n], up = new int[m][n];

        // 计算 left 数组和 up 数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                    up[i][j] = (i == 0) ? 1 : up[i - 1][j] + 1;
                }
            }
        }

        // 枚举正方形的边长，从大到小枚举
        for (int k = Math.min(m, n); k >= 1; k--) {
            for (int i = k - 1; i < m; i++) {
                for (int j = k - 1; j < n; j++) {
                    if (left[i][j] >= k && up[i][j] >= k
                            && left[i - k + 1][j] >= k && up[i][j - k + 1] >= k) {
                        return k * k;
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end
