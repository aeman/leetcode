import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(0);
            return list;
        }

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 构建邻接矩阵
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int x = findLongestNode(0, parent, adj);
        int y = findLongestNode(x, parent, adj);

        // 求出节点x到节点y的路径
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            list.add(path.get(m / 2 - 1));
        }
        list.add(path.get(m / 2));

        return list;
    }

    private int findLongestNode(int i, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(i);
        visit[i] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }
}
// @lc code=end
