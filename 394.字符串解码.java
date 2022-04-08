import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String subStr = sb.toString();
                stack.pop(); // remove '['

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString());

                for (int i = 0; i < count; i++) {
                    for (char subC : subStr.toCharArray()) {
                        stack.push(subC);
                    }
                }
            }
        }

        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty())
            retv.insert(0, stack.pop());

        return retv.toString();

        // return stack.stream().map(String::valueOf).sorted((a, b) -> -1).collect(Collectors.joining());
    }
}
// @lc code=end
