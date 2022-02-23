import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int x, y;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(x + y);
            } else if (token.equals("-")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(y - x);
            } else if (token.equals("*")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(x * y);
            } else if (token.equals("/")) {
                x = stack.pop();
                y = stack.pop();
                stack.push(y / x);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
// @lc code=end
