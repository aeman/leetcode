import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
