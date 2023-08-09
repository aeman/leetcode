/*
 * @lc app=leetcode.cn id=1749 lang=java
 *
 * [1749] 任意子数组和的绝对值的最大值
 */

// @lc code=start
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // int n = nums.length;
        // int dp[] = new int[n];
        // dp[0] = nums[0];
        // int maxSum = dp[0];

        // for (int i = 1; i < n; i++) {      
        //     dp[i] = Math.max(dp[i - 1], Math.abs(nums[i]));
        //     maxSum = Math.max(maxSum, dp[i]);
        // }
        // return maxSum;

        int maxEndingHere = 0;
        int maxSoFar = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        int minEndingHere = 0;
        int minSoFar = 0;
        
        for (int i = 0; i < nums.length; i++) {
            minEndingHere = Math.min(minEndingHere + nums[i], 0);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        
        return Math.max(maxSoFar, -minSoFar);
    }
}
// @lc code=end

