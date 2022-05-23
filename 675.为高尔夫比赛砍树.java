import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=675 lang=java
 *
 * [675] 为高尔夫比赛砍树
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int steps = 0;

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        int[][] grid = new int[m][n];

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                grid[i][j] = forest.get(i).get(j);
                if (forest.get(i).get(j) > 1)
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        Collections.sort(trees, (a, b) -> a[2] - b[2]);     //按树的高度从小到大排序

        int startX = 0, startY = 0;
        for (int i = 0; i < trees.size(); i++) {
            int dist = bfs(grid, startX, startY, trees.get(i)[0], trees.get(i)[1]);
            if (dist == -1) return -1;
                
            steps += dist;
            startX = trees.get(i)[0];
            startY = trees.get(i)[1];
        }

        // dfs(grid, 0, 0, 0);
        return steps;
    }

    private int bfs(int[][] grid, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) return 0;

        int m = grid.length, n = grid[0].length, dist = 0;
        boolean[][] visited = new boolean[m][n];
        visited[startX][startY] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && !visited[x][y]) {
                        if (x == targetX && y == targetY) return dist;
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, int prev) {
        int height = grid[i][j], m = grid.length, n = grid[0].length;
        if (height == 0 || height < prev)
            return;

        steps++;
        if (height > 1) {
            grid[i][j] = 1;
            // trees++;
        }
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(grid, x, y, height);
            }
        }
    }
}
// @lc code=end
