import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, sum = Arrays.stream(nums).sum();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[0] += i * nums[i];
        }

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + sum - n * nums[n - i];
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

