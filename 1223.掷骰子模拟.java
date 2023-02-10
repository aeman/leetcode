import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1223 lang=java
 *
 * [1223] 掷骰子模拟
 */

// @lc code=start
class Solution {
    private static final int MOD = 1000000007;
    private int[][][] dp;
    private int[] rollMax;
    private int n;

    public int dieSimulator(int n, int[] rollMax) {
        this.n = n;
        this.rollMax = rollMax;
        dp = new int[n][7][16];
        for (int[][] arr : dp) {
            for (int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res = (res + dfs(0, i + 1, 1)) % MOD;
        }
        return res;
    }

    private int dfs(int i, int j, int k) {
        if (k > rollMax[j - 1]) {
            return 0;
        }
        if (i == n - 1) {
            return 1;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int p = 0; p < 6; p++) {
            if (p + 1 == j) {
                res = (res + dfs(i + 1, p + 1, k + 1)) % MOD;
            } else {
                res = (res + dfs(i + 1, p + 1, 1)) % MOD;
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
// @lc code=end

