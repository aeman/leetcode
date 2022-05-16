import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
class Solution {
    private int[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        this.visited = new int[n];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i)) {
                list.add(i);
            }
        }
        return list;
    }

    // 0-unknown 1-visiting 2-safe
    private boolean dfs(int[][] graph, int from) {
        if (visited[from] == 2)
            return true;
        if (visited[from] == 1)
            return false;

        visited[from] = 1;
        for (int i : graph[from]) {
            if (!dfs(graph, i)) {
                return false;
            }
        }

        visited[from] = 2;
        return true;
    }
}
// @lc code=end
