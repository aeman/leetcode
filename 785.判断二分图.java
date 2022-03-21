/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {
    private boolean ans = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] color = new boolean[n], visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(graph, i, color, visited);
        }

        return ans;
    }

    private void dfs(int[][] graph, int i, boolean[] color, boolean[] visited) {
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

