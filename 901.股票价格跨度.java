import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {
    private Deque<int[]> stack = new ArrayDeque<>();
    private int index = -1;

    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        index++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

