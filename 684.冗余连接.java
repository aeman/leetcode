/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1]))
                return edge;
            else
                union(edge[0], edge[1]);
        }

        return edges[0];
    }

    private void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    private int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
// @lc code=end
