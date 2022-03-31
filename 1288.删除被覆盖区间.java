import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int curEnd, prevEnd = 0, count = 0;
        // 先按开始位置排序；如果开始位置相同，则结束位置大的排前面
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        for (int[] interval : intervals) {
            curEnd = interval[1];
            if (curEnd > prevEnd) {
                count++;
                prevEnd = curEnd;
            } 
        }

        return count;
    }
}
// @lc code=end

