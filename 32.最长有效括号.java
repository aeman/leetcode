import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // int left = 0, right = 0, max = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') left++; else right++;
        //     if (left == right) {
        //         max = Math.max(max, 2 * left);
        //     } else {
        //         if (right > left) left = right = 0;
        //     }
        // }
        // left = right = 0;
        // for (int i = s.length()-1; i >= 0; i--) {
        //     if (s.charAt(i) == ')') right ++; else left++;
        //     if (left == right) {
        //         max = Math.max(max, 2 * left);
        //     } else {
        //         if (left > right) left = right = 0;
        //     }
        // }

        // return max;
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
// @lc code=end

