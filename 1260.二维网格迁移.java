import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for (int t = 0; t < k; t++) {
            for (int i = 0; i < m; i++) {
                int temp = grid[i][n - 1];
                for (int j = n - 1; j > 0; j--) {
                    grid[i][j] = grid[i][j - 1];
                }
                grid[i][0] = temp;
            }
            int temp = grid[m - 1][0];
            for (int i = m - 1; i > 0; i--) {
                grid[i][0] = grid[i - 1][0];
            }
            grid[0][0] = temp;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
}
// @lc code=end
