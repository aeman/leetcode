import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1705 lang=java
 *
 * [1705] 吃苹果的最大数目
 */

// @lc code=start
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length, time = 0, ans = 0;

        while (time < n || !queue.isEmpty()) {
            // 每天长出的苹果，根据腐烂长短加入队列，时间短的排到队首，优先吃掉
            if (time < n) {
                queue.add(new int[] { time + days[time] - 1, apples[time] });
            }

            // 苹果到期腐烂掉
            while (!queue.isEmpty() && queue.peek()[0] < time)
                queue.poll();

            if (!queue.isEmpty()) {
                int[] cur = queue.peek();
                cur[1]--; // 每天吃掉一个苹果
                if (cur[1] == 0) queue.poll(); //这天的苹果吃光了，从队列中剔除
                ans++;
            }
            time++;
        }

        return ans;
    }
}
// @lc code=end
