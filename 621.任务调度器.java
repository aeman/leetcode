/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        // 最多执行次数 最多执行次数的任务数量
        int maxExec = 0, maxCount = 0;

        for (char task : tasks) {
            count[task - 'A']++;
            maxExec = Math.max(maxExec, count[task - 'A']);
        }

        for (int i : count) {
            if (i == maxExec) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxExec - 1) * (n + 1) + maxCount);
    }
}
// @lc code=end

