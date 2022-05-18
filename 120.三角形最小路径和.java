import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    // Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // memo = new Integer[n][n];
        // return dfs(triangle, 0, 0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    // public int dfs(List<List<Integer>> triangle, int i, int j) {
    //     if (i == triangle.size())
    //         return 0;

    //     if (memo[i][j] == null) {
    //         memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1))
    //                 + triangle.get(i).get(j);
    //     }

    //     return memo[i][j];
    // }
}
// @lc code=end
