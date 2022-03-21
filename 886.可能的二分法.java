import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {
    private boolean ans = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean[] color = new boolean[n + 1], visited = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) dfs(graph, i, color, visited);
        }

        return ans;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    private void dfs(List<Integer>[] graph, int i, boolean[] color, boolean[] visited) {
        if (ans == false) return;

        visited[i] = true;
        for (int j : graph[i]) {
            if (!visited[j]) {
                color[j] = !color[i];
                dfs(graph, j, color, visited);
            } else {
                if (color[i] == color[j]) ans = false;
            }
        }
    }
}
// @lc code=end

