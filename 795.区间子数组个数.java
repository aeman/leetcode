/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, last1 = -1, last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last1 = -1;
                last2 = i;
            }

            if (last1 != -1) {
                ans += last1 - last2;
            }
        }
        return ans;
    }
}
// @lc code=end

