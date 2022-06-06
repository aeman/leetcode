/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i <= reach; i++) {
            reach = Math.max(reach, nums[i] + i);
            if (reach >= nums.length - 1)
                return true;
        }
        return false;
    }
}
// @lc code=end
