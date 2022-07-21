import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=757 lang=java
 *
 * [757] 设置交集大小至少为2
 */

// @lc code=start
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = lists[i].size(); k < 2; j++, k++) {
                ans++;
                helper(intervals, lists, i - 1, j);
            }
        }
        return ans;
    }

    private void helper(int[][] intervals, List<Integer>[] lists, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) break;
            lists[i].add(num);
        }
    }
}
// @lc code=end

