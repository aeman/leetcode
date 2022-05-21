import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 在长度 2N 的数组中找出重复 N 次的元素
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length / 2 - 1] == nums[nums.length / 2 - 2]) {
            return nums[nums.length / 2 - 1];
        } else {
            return nums[nums.length / 2];
        }
    }
}
// @lc code=end

