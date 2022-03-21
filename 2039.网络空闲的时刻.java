import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=2039 lang=java
 *
 * [2039] 网络空闲的时刻
 */

// @lc code=start
class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        boolean[] visit = new boolean[n];
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit[0] = true;
        int dist = 1;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int edge : adj[curr]) {
                    if (visit[edge]) {
                        continue;
                    }
                    queue.offer(edge);
                    int time = patience[edge] * ((2 * dist - 1) / patience[edge]) + 2 * dist + 1;
                    ans = Math.max(ans, time);
                    visit[edge] = true;
                }
            }
            dist++;
        }
        return ans;
    }
}
// @lc code=end
