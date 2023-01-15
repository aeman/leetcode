/*
 * @lc app=leetcode.cn id=2293 lang=java
 *
 * [2293] 极大极小游戏
 */

// @lc code=start
class Solution {
    public int minMaxGame(int[] nums) {
        int[] arr = nums;
        while (nums.length > 1) {
            int n = nums.length / 2;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    arr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = arr;
        }
        return arr[0];
    }
}
// @lc code=end
