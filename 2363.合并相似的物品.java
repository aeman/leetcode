import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=2363 lang=java
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            Integer value = items1[i][0], weight = items1[i][1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        for (int i = 0; i < items2.length; i++) {
            Integer value = items2[i][0], weight = items2[i][1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        List<List<Integer>> list = map.entrySet().stream().map(x -> {
            List<Integer> l = new ArrayList<>();
            l.add(x.getKey());
            l.add(x.getValue());
            return l;
        }).collect(Collectors.toList());
        list.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return list;
    }
}
// @lc code=end

