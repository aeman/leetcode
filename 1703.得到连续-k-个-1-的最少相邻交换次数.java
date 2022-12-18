import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1703 lang=java
 *
 * [1703] 得到连续 K 个 1 的最少相邻交换次数
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<>();
        List<Integer> preSum = new ArrayList<>();

        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }

        int m = g.size(), ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            int temp = (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i));
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
// @lc code=end
