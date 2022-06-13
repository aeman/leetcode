import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

