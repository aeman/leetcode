import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
class Solution {
    Map<String, Integer> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建有向图的邻接表
        List<double[]>[] graph = buildGraph(equations, values);
        int index = 0;
        double[] answer = new double[queries.size()];
        for (List<String> query : queries) {
            // 如果存在未知变量 返回-1
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                answer[index++] = -1;
                continue;
            }
            // 进行dfs搜索
            answer[index++] = dfs(graph, map.get(query.get(0)), map.get(query.get(1)), new HashSet<Integer>(), 1);
        }
        return answer;
    }

    /**
     * 
     * @param graph   邻接表
     * @param cur     当前节点
     * @param end     终点
     * @param visited 存储已经访问过的节点
     * @param result  结果
     * @return
     */
    double dfs(List<double[]>[] graph, int cur, int end, HashSet<Integer> visited, double result) {
        // 如果已经访问过
        if (visited.contains(cur)) {
            return -1;
        }
        // 如果遍历到终点
        if (cur == end) {
            // 返回结果
            return result;
        }
        // 标记节点已经访问过
        visited.add(cur);
        // 遍历其邻接点
        for (double[] next : graph[cur]) {
            double temp = dfs(graph, (int) next[0], end, visited, result * next[1]);
            // 如果返回结果不为-1
            if (temp != -1) {
                // 说明找到结果 返回即可
                return temp;
            }
        }
        return -1;
    }

    // 构建有向图的邻接表
    List<double[]>[] buildGraph(List<List<String>> equations, double[] values) {
        int index = 0;
        // 遍历变量对数组
        for (List<String> pair : equations) {
            String a = pair.get(0);
            String b = pair.get(1);
            // 为每一个变量映射整数索引
            if (!map.containsKey(a)) {
                map.put(a, index++);
            }
            if (!map.containsKey(b)) {
                map.put(b, index++);
            }
        }
        List<double[]>[] graph = new LinkedList[map.size()];
        for (int i : map.values()) {
            graph[i] = new LinkedList();
        }
        index = 0;
        // 构建邻接表
        for (List<String> pair : equations) {
            int a = map.get(pair.get(0));
            int b = map.get(pair.get(1));
            double ans = values[index++];
            graph[a].add(new double[] { (double) b, ans });
            ans = 1 / ans;
            graph[b].add(new double[] { (double) a, ans });
        }
        return graph;
    }
}
// @lc code=end
