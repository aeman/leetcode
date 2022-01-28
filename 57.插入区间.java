import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean placed = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(intervals[i]);
            } else if (intervals[i][1] < left) {
                list.add(intervals[i]);
            } else {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }

        if (!placed) {
            list.add(new int[]{left, right});
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
// @lc code=end

