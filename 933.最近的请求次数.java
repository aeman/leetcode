import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {
    private Deque<Integer> stack;

    public RecentCounter() {
        stack = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        stack.offer(t);
        while (stack.peek() < t - 3000) {
            stack.poll();
        }
        return stack.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

