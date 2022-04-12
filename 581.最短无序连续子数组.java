/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = 0, right = -1;
        int maxVal = nums[0], minVAl = nums[n - 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] < maxVal) {
                right = i;
            } else {
                maxVal = nums[i]; // 从左到右维持最大值
            }

            if (nums[n - i - 1] > minVAl) {
                left = n - i - 1;
            } else {
                minVAl = nums[n - i - 1]; // 从右到左维持最小值
            }
        }

        return right - left + 1;
    }
}
// @lc code=end
