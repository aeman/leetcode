import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length, sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;

        // reverse sort
        Arrays.sort(matchsticks);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return dfs(matchsticks, edges, 0, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] edges, int index, int len) {
        if (index == matchsticks.length) return true;

        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(matchsticks, edges, index + 1, len)) return true;
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
// @lc code=end

