import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') stack.pop();
            if (!stack.isEmpty()) sb.append(c);
            if (c == '(') stack.push(c);
        }

        return sb.toString();
    }
}
// @lc code=end

