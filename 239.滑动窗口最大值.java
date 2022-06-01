import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        // 1.优先队列
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        // 2.单调队列
        // Deque<Integer> queue = new ArrayDeque<>();
        // for (int i = 0; i < nums.length; i++) {
        //     while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
        //         queue.pollLast();
        //     }
        //     queue.offer(nums[i]);
        //     if (i >= k && nums[i - k] == queue.peek()) {
        //         queue.poll();
        //     }
        //     if (i >= k - 1) {
        //         ans[i - k + 1] = queue.peek();
        //     }
        // }

        return ans;
    }
}
// @lc code=end
