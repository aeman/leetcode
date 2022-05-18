/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;

        int ans = 0;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] dir : dirs) {
                            int x = j + dir[0], y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                dp[i + 1][x][y] = (dp[i + 1][x][y] + count) % MOD;
                            } else {
                                ans = (ans + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
