/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int k = 0; k < trips.length; k++) {
            int i = trips[k][1], j = trips[k][2], val = trips[k][0];
            diff[i] += val;
            diff[j] -= val;
        }

        int[] ans = new int[1001];
        ans[0] = diff[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > capacity) return false;
        }

        return true;
    }
}
// @lc code=end

