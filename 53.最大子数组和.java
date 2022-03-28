import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(dp[i]);
        // }

        //先排序，然后找出最大值
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

