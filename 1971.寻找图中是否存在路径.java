import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1971 lang=java
 *
 * [1971] 寻找图中是否存在路径
 */

// @lc code=start
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        boolean[] visited = new boolean[n];

        // 1.bfs
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == destination) break;
            for (int next : adj[x]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];

        // 2.dfs
        // return dfs(source, destination, adj, visited);
    }

    private boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
        if (source == destination) return true;
        visited[source] = true;
        for (int next : adj[source]) {
            if (!visited[next] && dfs(next, destination, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

