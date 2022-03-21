import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans =  new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, list);
        return ans;
    }

    private void dfs(int[][] graph, int cur, List<Integer> list) {
        if (cur == graph.length - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int next : graph[cur]) {
            list.add(next);
            dfs(graph, next, list);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

