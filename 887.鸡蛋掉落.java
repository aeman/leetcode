/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        // 只有一层楼，只需要扔一次蛋
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }

        int ans = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            // 找到该楼层i
            if (dp[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
