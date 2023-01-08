import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1801 lang=java
 *
 * [1801] 积压订单中的订单总数
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> qBuy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> qSell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) {
                while (amount > 0 && !qSell.isEmpty() && price >= qSell.peek()[0]) {
                    int[] sellOrder = qSell.poll();
                    int sellAmount = Math.min(amount, sellOrder[1]);
                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;
                    if (sellOrder[1] > 0) {
                        qSell.offer(sellOrder);
                    }
                }
                if (amount > 0) {
                    qBuy.offer(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !qBuy.isEmpty() && price <= qBuy.peek()[0]) {
                    int[] buyOrder = qBuy.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);
                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;
                    if (buyOrder[1] > 0) {
                        qBuy.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    qSell.offer(new int[]{price, amount});
                }
            }
        }

        int ans = 0;
        for (Queue<int[]> pq : Arrays.asList(qBuy, qSell)) {
            while (!pq.isEmpty()) {
                int[] order = pq.poll();
                ans = (ans + order[1]) % MOD;
            }
        }
        return ans;
    }
}
// @lc code=end

