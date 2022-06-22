import java.util.ArrayDeque;
import java.util.Deque;

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
        int[] colors = new int[n];   // -1：红色 1：绿色 0：未访问

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) bfs(graph, i, colors, -1);
            // if (colors[i] == 0) dfs(graph, i, colors, -1);
        }

        return ans;
    }

    private void bfs(int[][] graph, int i, int[] colors, int color) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        colors[i] = color;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : graph[cur]) {
                if (colors[neighbor] != 0) {    // 访问过
                    if (colors[neighbor] == colors[cur]) {
                        ans = false;
                        return;
                    }
                } else {    //未访问
                    colors[neighbor] = -1 * colors[cur];  //设置不同颜色
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void dfs(int[][] graph, int i, int[] colors, int color) {
        if (ans == false || colors[i] != 0) return;

        colors[i] = color;
        for (int neighbor : graph[i]) {
            if (colors[neighbor] == 0) {       // 未访问
                dfs(graph, neighbor, colors, -1 * colors[i]);  //设置不同颜色
            } else {        // 访问过
                if (colors[i] == colors[neighbor]) {
                    ans = false;
                    return;
                }
            }
        }
    }
}
// @lc code=end

