/*
 * @lc app=leetcode.cn id=1413 lang=java
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return Math.abs(min) + 1;
    }
}
// @lc code=end

