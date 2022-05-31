import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        int[] ans = new int[nums.length];

        while (left <= right) {
            int lVal = nums[left] * nums[left], rVal = nums[right] * nums[right];
            if (lVal < rVal) {
                ans[index--] = rVal;
                right--;
            } else {
                ans[index--] = lVal;
                left++;
            }
        }

        return ans;
    }
}
// @lc code=end

