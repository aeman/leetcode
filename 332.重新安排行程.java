import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> routes = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to);
        }

        dfs("JFK");
        Collections.reverse(routes);
        return routes;
    }

    private void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String next = map.get(cur).poll();
            dfs(next);
        }
        routes.add(cur);
    }
}
// @lc code=end

