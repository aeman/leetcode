/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
// @lc code=end
