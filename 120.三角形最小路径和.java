import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    public int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;

        if (memo[i][j] == null) {
            memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) 
                + triangle.get(i).get(j);
        }

        return memo[i][j];
    }
}
// @lc code=end

