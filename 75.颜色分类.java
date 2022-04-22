/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int pos = 0;

        while (pos <= right) {
            if (nums[pos] == 0) {
                nums[pos] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[pos] == 2) {
                nums[pos] = nums[right];
                nums[right] = 2;
                right--;
                pos--;
            }
            pos++;
        }
    }
}
// @lc code=end

