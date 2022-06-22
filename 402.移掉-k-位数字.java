import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        // 单调栈，新增元素大于栈中最后一个元素
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > c) {
                queue.pollLast();
                k--;
            }
            queue.offer(c);
        }

        for (int i = 0; i < k; i++) {
            queue.pollLast();
        }


        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (isZero && c == '0') continue;
            isZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

