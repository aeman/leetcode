import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
class Solution {
    private List<Integer>[] graph;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, ans);
        }
        return ans;
    }

    private void dfs(int idx, int[] quiet, int[] ans) {
        if (ans[idx] != -1) return;
        
        ans[idx] = idx;
        for (int i : graph[idx]) {
            dfs(i, quiet, ans);
            if (quiet[ans[i]] < quiet[ans[idx]]) {
                ans[idx] = ans[i];
            }
        }
    }
}
// @lc code=end

