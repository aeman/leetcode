import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1449 lang=java
 *
 * [1449] 数位成本和为目标值的最大数字
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= 9; i++) {
            int u = cost[i - 1];
            for (int j = u; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - u] + 1);
            }
        }
        
        if (dp[target] < 0)
            return "0";
        
        String ans = "";
        for (int i = 9, j = target; i >= 1; i--) {
            int u = cost[i - 1];
            while (j >= u && dp[j] == dp[j - u] + 1) {
                ans += String.valueOf(i);
                j -= u;
            }
        }
        return ans;
    }
}
// @lc code=end
