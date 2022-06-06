/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int step = 0, end = 0, max = 0;

        // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前步数下能跳到的最远位置
            max = Math.max(max, i + nums[i]);
            if (i == end) { // 到达当前边界，需要继续跳一步
                step++;
                end = max;
            }
        }
        
        return step;
    }
}
// @lc code=end

