import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.offer(new int[] { i * n + j, heightMap[i][j] });
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] / n + dir[0], y = cur[0] % n + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    if (cur[1] > heightMap[x][y]) {
                        ans += cur[1] - heightMap[x][y];
                    }
                    queue.offer(new int[] { x * n + y, Math.max(cur[1], heightMap[x][y]) });
                    visited[x][y] = true;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
