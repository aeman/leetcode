/*
 * @lc app=leetcode.cn id=801 lang=java
 *
 * [801] 使序列递增的最小交换次数
 */

// @lc code=start
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int dp0 = 0, dp1 = 1;
        for (int i = 1; i < n; i++) {
            int t0 = dp0, t1 = dp1;
            dp0 = dp1 = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp0 = Math.min(dp0, t0);
                dp1 = Math.min(dp1, t1 + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp0 = Math.min(dp0, t1);
                dp1 = Math.min(dp1, t0 + 1);
            }
        }
        return Math.min(dp0, dp1);
    }
}
// @lc code=end
