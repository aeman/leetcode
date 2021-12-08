import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            if (c == '[') stack.push(']');
            if (c == '(') stack.push(')');

            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty() || c != stack.pop()) return false;
            }
        }
        
        return stack.isEmpty();
    }
}
// @lc code=end

