/*
 * @lc app=leetcode.cn id=1764 lang=java
 *
 * [1764] 通过连接另一个数组的子数组得到一个数组
 */

// @lc code=start
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length && len < groups.length;) {
            if (check(groups[len], nums, i)) {
                i += groups[len].length;
                len++;
            } else {
                i++;
            }
        }
        return len == groups.length;
    }

    private boolean check(int[] group, int[] nums, int idx) {
        if (idx + group.length > nums.length)
            return false;

        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[idx + i])
                return false;
        }

        return true;
    }
}
// @lc code=end
