/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
                ans = Math.max(ans, sum);
            } else {
                sum = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

