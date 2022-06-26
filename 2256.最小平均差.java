/*
 * @lc app=leetcode.cn id=2256 lang=java
 *
 * [2256] 最小平均差
 */

// @lc code=start
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int ans = 0, n = nums.length;
        long diff = Long.MAX_VALUE;
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            long left = sum[i] / (i + 1);
            long right = 0;
            if (n - 1 > i) {
                right = (sum[n - 1] - sum[i]) / (n - 1 - i);
            }
            if (diff > Math.abs(left - right)) {
                diff = Math.abs(left - right);
                ans = i;
            }
            
        }

        return ans;
    }
}
// @lc code=end

