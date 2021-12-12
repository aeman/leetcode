/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int pos = -1, pos2 = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
                break;
            }
        }

        // 倒序数组，直接反转
        if (pos == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[pos]) {
                pos2 = i;
                break;
            }
        }
        swap(nums, pos, pos2);
        reverse(nums, pos + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

