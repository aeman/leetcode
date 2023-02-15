/*
 * @lc app=leetcode.cn id=1250 lang=java
 *
 * [1250] 检查「好数组」
 */

// @lc code=start
class Solution {
    public boolean isGoodArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = gcd(ans, nums[i]);
        }
        return ans == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
// @lc code=end

