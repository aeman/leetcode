import java.util.List;

/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0;

        // 分析时间串，保存到数组中
        boolean[] times = new boolean[1440];  // 一天的分钟数
        for (String time : timePoints) {
            String[] arr = time.split(":");
            int minites = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            if (times[minites]) return 0;
            times[minites] = true;
        }

        // 比较相邻两个时间的时间差，注意考虑首尾时间
        int diff = Integer.MAX_VALUE, head = 1440, tail = 0;

        int prev = -1;
        for (int i = 0; i < times.length; i++) {
            if (times[i]) {
                if (prev >= 0) {
                    diff = Math.min(diff, i - prev);
                }
                prev = i;
                head = Math.min(head, i);
                tail = Math.max(tail, i);
            }
        }

        // 首尾元素相邻，比较
        diff = Math.min(diff, head + 1440 - tail);
        return diff;
    }
}
// @lc code=end

