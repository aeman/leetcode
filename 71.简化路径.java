import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.append("/").append(stack.pollLast());
            }
        }

        return sb.toString();
    }
}
// @lc code=end

