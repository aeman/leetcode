import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    private int index;
    private boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses - 1;
        int[] visited = new int[numCourses], ans = new int[numCourses];

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) dfs(edges, visited, i, ans);
        }
        
        if (!valid) {
            return new int[0];
        }
        return ans;
    }

    private void dfs(List<List<Integer>> edges, int[] visited, int course, int[] ans) {
        visited[course] = 1;
        for (int i : edges.get(course)) {
            if (visited[i] == 0) {
                dfs(edges, visited, i, ans);
                if (!valid) return;
            } else if (visited[i] == 1) {
                valid = false;
                return;
            }
        }
        visited[course] = 2;

        ans[index--] = course;
    }
}
// @lc code=end

