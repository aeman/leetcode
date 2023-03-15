/*
 * @lc app=leetcode.cn id=1615 lang=java
 *
 * [1615] 最大网络秩
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] adj = new int[n][n]; // 邻接矩阵
        int[] degree = new int[n];   // 每个城市的度数

        // 构建邻接矩阵
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            adj[a][b] = adj[b][a] = 1;
            degree[a]++;
            degree[b]++;
        }

        int maxRank = 0;
        // 枚举所有城市对
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 计算城市对的网络秩
                int rank = degree[i] + degree[j] - adj[i][j];
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
// @lc code=end
