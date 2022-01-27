/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int step = 0, end = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前步数下能跳到的最远位置
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }
}
// @lc code=end

