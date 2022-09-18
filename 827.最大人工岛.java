import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

// @lc code=start
class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int largestIsland(int[][] grid) {
        int ans = 0, n = grid.length;
        int[][] tag = new int[n][n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1;
                    map.put(t, dfs(grid, i, j, tag, t));
                    ans = Math.max(ans, map.get(t));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || tag[x][y] == 0 || set.contains(tag[x][y])) {
                            continue;
                        }
                        area += map.get(tag[x][y]);
                        set.add(tag[x][y]);
                    }
                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int[][] tag, int t) {
        int ans = 1, n = grid.length;
        tag[i][j] = t;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1 && tag[x][y] == 0) {
                ans += dfs(grid, x, y, tag, t);
            }
        }
        return ans;
    }
}
// @lc code=end
