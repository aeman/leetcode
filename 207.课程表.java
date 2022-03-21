import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edges, visited, i)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> edges, int[] visited, int course) {
        if(visited[course] == 1) return false;
        if(visited[course] == -1) return true;

        visited[course] = 1;
        for (int i = 0; i < edges.get(course).size(); i++) {
            if (!dfs(edges, visited, edges.get(course).get(i))) return false;
        }
        visited[course] = -1;
        
        return true;
    }
}
// @lc code=end

