/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int begin = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                sum = 0;
                i = begin + 1;
                count++;
            } else if (sum > k) {
                sum = 0;
                i = begin + 1;
            }
        }
        return count;
    }
}
// @lc code=end

