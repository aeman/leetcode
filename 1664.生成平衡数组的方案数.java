/*
 * @lc app=leetcode.cn id=1664 lang=java
 *
 * [1664] 生成平衡数组的方案数
 */

// @lc code=start
class Solution {
    public int waysToMakeFair(int[] nums) {
        int ans = 0, s = 0, n = nums.length;
        for (int i = 0; i < n; ++i)
            s += i % 2 == 0 ? nums[i] : -nums[i];
        for (int i = 0; i < n; ++i) {
            s -= i % 2 == 0 ? nums[i] : -nums[i];
            ans += s == 0 ? 1 : 0;
            s -= i % 2 == 0 ? nums[i] : -nums[i];
        }
        return ans;
    }
}
// @lc code=end
