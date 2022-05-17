import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1631 lang=java
 *
 * [1631] 最小体力消耗路径
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[] { 0, 0, 0 });

        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        for (int[] dis : dist) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int i = edge[0], j = edge[1], d = edge[2];
            if (visited[i][j])
                continue;

            if (i == m - 1 && j == n - 1)
                break;
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int diff = Math.max(d, Math.abs(heights[x][y] - heights[i][j]));
                    if (diff < dist[x][y]) {
                        dist[x][y] = diff;
                        queue.offer(new int[] { x, y, diff });
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
// @lc code=end
