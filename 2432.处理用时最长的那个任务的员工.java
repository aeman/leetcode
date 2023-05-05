/*
 * @lc app=leetcode.cn id=2432 lang=java
 *
 * [2432] 处理用时最长的那个任务的员工
 */

// @lc code=start
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ans = 0, start = 0, maxDuration = 0;
        for (int[] log : logs) {
            int duration = log[1] - start;
            if (duration > maxDuration) {
                maxDuration = duration;
                ans = log[0];
            } else if (duration == maxDuration && log[0] < ans) {
                ans = log[0];
            }
            start = log[1];
        }
        return ans;
    }
}
// @lc code=end

