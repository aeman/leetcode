/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums.length;
    }
}
// @lc code=end
