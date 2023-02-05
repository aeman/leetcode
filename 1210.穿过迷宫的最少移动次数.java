import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1210 lang=java
 *
 * [1210] 穿过迷宫的最少移动次数
 */

// @lc code=start
class Solution {
    private static int[][] dirs = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][2];
        List<int[]> queue = new ArrayList<>();
        visited[0][0][0] = true;
        queue.add(new int[] { 0, 0, 0 });
        for (int step = 1; !queue.isEmpty(); ++step) {
            List<int[]> tmp = queue;
            queue = new ArrayList<>();
            for (int[] t : tmp) {
                for (int[] d : dirs) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n && !visited[x][y][s] &&
                            grid[x][y] == 0 && grid[x2][y2] == 0 && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2)
                            return step; // 此时蛇头一定在 (n-1,n-1)
                        visited[x][y][s] = true;
                        queue.add(new int[] { x, y, s });
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end
