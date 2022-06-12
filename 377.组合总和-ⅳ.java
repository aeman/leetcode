/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        // 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
// @lc code=end
