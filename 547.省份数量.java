import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, circle = n;
        // boolean[] visited = new boolean[n];
        
        int[] fathers = new int[n];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < fathers.length; j++) {
                if (isConnected[i][j] == 1 && union(fathers, i, j)) {
                    circle--;
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     if (!visited[i]) {
        //         bfs(isConnected, visited, n, i);
        //         dfs(isConnected, visited, n, i);
        //         circle++;
        //     }
        // }

        return circle;
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherI = findFather(fathers, i);
        int fatherJ = findFather(fathers, j);
        if (fatherI != fatherJ) {
            fathers[fatherI] = fatherJ;
            return true;
        }
        return false;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    private void bfs(int[][] isConnected, boolean[] visited, int n, int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 0; j < n; j++) {
                if (isConnected[cur][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
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

