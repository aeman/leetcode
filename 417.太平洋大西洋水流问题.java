import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific =  new boolean[m][n];
        boolean[][] atlantic =  new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n - 1, atlantic, heights);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i,  pacific, heights);
            dfs(m - 1, i, atlantic,  heights);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        int m = heights.length, n = heights[0].length;

        if (ocean[i][j]) return;
        ocean[i][j]  = true;

        for (int[] dir : dirs) {
            int i2 = i + dir[0], j2 = j + dir[1];
            // 超出边界不考虑
            if (i2 < 0 || i2 >= m || j2 < 0 || j2 >= n) continue;

            if (heights[i2][j2] >= heights[i][j]) {
                dfs(i2, j2, ocean, heights);
            }
        }
    }
}
// @lc code=end

