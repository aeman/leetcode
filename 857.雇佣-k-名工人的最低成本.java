import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=857 lang=java
 *
 * [857] 雇佣 K 名工人的最低成本
 */

// @lc code=start
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] high = new Integer[n];
        for (int i = 0; i < n; i++) {
            high[i] = i;
        }

        Arrays.sort(high, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);

        double ans = 1e9, totalq = 0.0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[high[i]];
            queue.offer(quality[high[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int idx = high[i];
            totalq += quality[idx];
            queue.offer(quality[idx]);
            double totalc = ((double) wage[idx] / quality[idx]) * totalq;
            ans = Math.min(ans, totalc);
            totalq -= queue.poll();
        }

        return ans;
    }
}
// @lc code=end
