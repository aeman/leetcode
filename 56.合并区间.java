import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] ans = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int index = 0;
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans[index][0] = start;
                ans[index][1] = end;
                index++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans[index][0] = start;
        ans[index][1] = end;

        return Arrays.copyOfRange(ans, 0, index + 1);
    }
}
// @lc code=end
