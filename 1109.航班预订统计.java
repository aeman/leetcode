/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 利用差分数组diff设置订购数量
        int[] diff = new int[n];
        for (int k = 0; k < bookings.length; k++) {
            int i = bookings[k][0], j = bookings[k][1], val = bookings[k][2];
            diff[i - 1] += val;
            if (j < n) {
                diff[j] -= val;
            }
        }

        // 差分数组还原订购数组
        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
// @lc code=end
