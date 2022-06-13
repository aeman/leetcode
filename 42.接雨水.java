import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;

        // 1.双指针
        // int[] left_max = new int[n], right_max = new int[n];
        // left_max[0] = height[0];
        // right_max[n - 1] = height[n - 1];

        // for (int i = 1; i < n; i++) {
        //     left_max[i] = Math.max(left_max[i - 1], height[i]);
        // }

        // for (int i = n - 2; i >= 0; i--) {
        //     right_max[i] = Math.max(right_max[i + 1], height[i]);
        // }

        // for (int i = 0; i < n; i++) {
        //     ans += Math.min(left_max[i], right_max[i]) - height[i];
        // }

        // 2.单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int cWidth = i  - left - 1, cHeight = Math.min(height[i], height[left])  - height[top];
                ans += cWidth * cHeight;
            }
            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end
