import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] task = log.split(":");
            int funcId = Integer.parseInt(task[0]), time = Integer.parseInt(task[2]);
            if (task[1].equals("start")) {
                if (!stack.isEmpty()) {
                    int[] prev = stack.peek();
                    ans[prev[0]] += time - prev[1];
                }
                stack.push(new int[] { funcId, time });
            } else if (task[1].equals("end")) {
                int[] curr = stack.pop();
                ans[funcId] += time - curr[1] + 1;
                if (!stack.isEmpty()) {
                    int[] prev = stack.peek();
                    prev[1] = time + 1;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
