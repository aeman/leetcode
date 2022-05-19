import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length / 2];
        
        int ans = 0;
        for (int i : nums) {
            ans += Math.abs(i - x);
        }
        return ans;
    }
}
// @lc code=end

