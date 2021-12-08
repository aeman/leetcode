import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        // for (int i = 0; i < nums.length - k + 1; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i + k; j++) {
        //         if (nums[j] > max) max = nums[j];
        //     }      
        //     ans[i] = max; 
        // }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = deque.peekFirst();
            }
        }
        return ans;
    }
}
// @lc code=end

