/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        // boolean[][] visited  = new boolean[m][n];
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        // if (visited[sr][sc]) return;
        if (color == image[sr][sc]) return;
        
        int m = image.length, n = image[0].length;
        image[sr][sc] = color;
        // visited[sr][sc] = true;
        for (int[] dir : dirs) {
            int x = sr + dir[0], y = sc + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
                dfs(image, x, y, color, oldColor);
            }
        }
    }
}
// @lc code=end
