import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=891 lang=java
 *
 * [891] 子序列宽度之和
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        long x = nums[0], y = 2;
        for (int i = 1; i < nums.length; i++) {
            ans = (ans + nums[i] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[i]) % MOD;
            y = y * 2 % MOD;
        }
        return (int) ((ans + MOD) % MOD);
    }
}
// @lc code=end
