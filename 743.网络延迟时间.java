import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
class Solution {
    private int INF = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 根据times初始化图
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];    //到达各个节点的最短时间
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;    //起始节点

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!visited[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            visited[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + graph[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
// @lc code=end

