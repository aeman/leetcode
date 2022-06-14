/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n], map = new int[101];

        for (int i = 0; i < n; i++) {
            map[nums[i]] += 1;
        }

        for (int i = 1; i <= 100; i++) {
            map[i] += map[i - 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] == 0 ? 0 : map[nums[i] - 1];
        }
        return ans;
    }
}
// @lc code=end
