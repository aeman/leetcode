/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0, n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) ans++;
        }
        return ans;
    }
}
// @lc code=end

