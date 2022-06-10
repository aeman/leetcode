import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        // 1.backtrack
        // backtrack(nums, target, 0, 0);
        // return count;

        // 2.dp
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0)
            return 0;

        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target)
                count++;
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
// @lc code=end
