import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1462 lang=java
 *
 * [1462] 课程表 IV
 */

// @lc code=start
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] arr = new boolean[101][101];

        for (int[] pre : prerequisites) {
            int left = pre[0], right = pre[1];
            arr[left][right] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(arr[query[0]][query[1]]);
        }
        return ans;
    }
}
// @lc code=end
