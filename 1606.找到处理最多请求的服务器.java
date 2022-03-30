import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1606 lang=java
 *
 * [1606] 找到处理最多请求的服务器
 */

// @lc code=start
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        Queue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty())
                continue;

            Integer server = available.ceiling(i % k);
            if (server == null)
                server = available.first();
            requests[server]++;
            busy.offer(new int[] { arrival[i] + load[i], server });
            available.remove(server);
        }

        int maxRequests = Arrays.stream(requests).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequests) {
                list.add(i);
            }
        }
        return list;
    }
}
// @lc code=end
