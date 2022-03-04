/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
// @lc code=end
