/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] 递减元素使数组呈锯齿状
 */

// @lc code=start
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int evenMoves = 0, oddMoves = 0;
        for (int i = 0; i < n; i++) {
            int leftDiff = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int rightDiff = i == n - 1 ? Integer.MAX_VALUE : nums[i + 1];
            int diff = Math.max(0, nums[i] - Math.min(leftDiff, rightDiff) + 1);
            if (i % 2 == 0) {
                evenMoves += diff;
            } else {
                oddMoves += diff;
            }
        }
        return Math.min(evenMoves, oddMoves);
    }
}
// @lc code=end
