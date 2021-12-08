import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            } else if (tokens[i].equals("*")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
            } else if (tokens[i].equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);                
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
// @lc code=end

