import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) return 1;
            sum[i + 1] = sum[i] + nums[i];
        }

        // 单调队列保证窗口内值的单调性
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && sum[i] <= sum[queue.peekLast()]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && sum[i] - sum[queue.peek()] >= k) {
                ans = Math.min(ans, i - queue.poll());
            }
            queue.offer(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end
