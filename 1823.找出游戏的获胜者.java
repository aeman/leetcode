import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=1823 lang=java
 *
 * [1823] 找出游戏的获胜者
 */

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());  //轮流报数模拟
            }
            queue.poll();   //正好等于k，淘汰
        }
        return queue.peek();
    }
}
// @lc code=end

