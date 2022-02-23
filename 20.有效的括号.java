import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.pop() != '(') return false;
                if (c == ']' && stack.pop() != '[') return false;
                if (c == '}' && stack.pop() != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }
}
// @lc code=end

