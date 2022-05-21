import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = Arrays.stream(nums).sum(), max = Arrays.stream(nums).max().getAsInt();
        if (sum % 2 != 0 || n < 2) return false;
        int target = sum / 2;
        //如果 maxNum>target，则除了 maxNum 以外的所有元素之和一定小于 target，因此不可能将数组分割成元素和相等的两个子集
        if (max > target) return false;

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] =  dp[i - 1][j] || dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }
}
// @lc code=end

