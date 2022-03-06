/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int circle = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                circle++;
            }
        }

        return circle;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }
}
// @lc code=end

