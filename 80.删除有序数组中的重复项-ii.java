/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // int slow = 2, fast = 2;
        // while (fast < nums.length) {
        //     // 不是连续出现3次相同数字的情况
        //     if (nums[fast] != nums[slow - 2]) {
        //         nums[slow] = nums[fast];
        //         slow++;
        //     }
        //     fast++;
        // }
        // return slow;

        int length = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[length - 2]) {
                nums[length] = nums[i];
                length++;
            }
        }

        return length;
    }
}
// @lc code=end

