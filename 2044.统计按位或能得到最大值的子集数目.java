/*
 * @lc app=leetcode.cn id=2044 lang=java
 *
 * [2044] 统计按位或能得到最大值的子集数目
 */

// @lc code=start
class Solution {
    private int count = 0, maxOr = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int orVal) {
        if (index == nums.length) {
            if (orVal == maxOr) {
                count++;
            } else if (orVal > maxOr) {
                count = 1;
                maxOr = orVal;
            }
            return;
        }

        dfs(nums, index + 1, orVal | nums[index]);
        dfs(nums, index + 1, orVal);
    }
}
// @lc code=end
