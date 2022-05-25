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
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") 
                && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                stack.push(calc(stack.pop(), stack.pop(), token));
            }
        }
        return stack.pop();
    }

    private int calc(int x, int y, String token) {
        switch (token) {
            case "+":
                return x + y;
            case "-":
                return y - x;
            case "*":
                return x * y;
            case "/":
                return y / x;
            default:
                return 1;
        }
    }
}
// @lc code=end
