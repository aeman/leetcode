import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边界着色
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int m, n, originColor;
    private boolean[][] visited;
    private List<int[]> borders;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.originColor = grid[row][col];
        this.visited = new boolean[m][n];
        this.borders = new ArrayList<>();

        visited[row][col] = true;
        dfs(grid, row, col);

        for (int[] board : borders) {
            grid[board[0]][board[1]] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col) {
        boolean isBorder = false;
        for (int[] dir : dirs) {
            int row2 = row + dir[0], col2 = col + dir[1];
            if (!(row2 >= 0 && row2 < m && col2 >= 0 && col2 < n && grid[row2][col2] == originColor)) {
                isBorder = true;
            } else if (!visited[row2][col2]) {
                visited[row2][col2] = true;
                dfs(grid, row2, col2);
            }
        }
        if (isBorder) {
            borders.add(new int[]{row, col});
        }
    }
}
// @lc code=end

