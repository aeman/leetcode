import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int value = stack.pop();
                int sum = stack.pop() + Math.max(value * 2, 1);
                stack.push(sum);
            }
        }
        return stack.peek();
    }
}
// @lc code=end

