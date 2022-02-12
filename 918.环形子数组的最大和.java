/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = nums[0], curMin = nums[0], maxSum = nums[0], minSum = nums[0], sum = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);
            sum += nums[i];
        }

        // 两种情况，一种连续数组分段，一种不分段
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
// @lc code=end

