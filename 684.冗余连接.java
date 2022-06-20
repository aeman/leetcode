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

        // 初始化各节点的顶点为自己
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            // 如果两个点的顶点已经连通，说明加上这条边会导致环出现，返回
            if (find(edge[0]) == find(edge[1]))
                return edge;
            else
                union(edge[0], edge[1]);    // 连通这两个节点为同一顶点
        }

        return edges[0];
    }

    private void union(int x, int y) {
        parent[find(y)] = find(x);      // 把x连接到y上
    }

    private int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
// @lc code=end
