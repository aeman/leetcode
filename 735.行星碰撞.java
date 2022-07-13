import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            // 右向左穿透
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                stack.pop();
            }

            if (!stack.isEmpty() && a < 0 && stack.peek() == -a) {  // 左右同归于尽
                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0 || a > 0) {  // 不会发生碰撞的三种情况
                stack.push(a);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }
}
// @lc code=end

