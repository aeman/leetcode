import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < minSum) {
                    minSum = i + j;
                    list.clear();
                    list.add(list2[i]);
                } else if (i + j == minSum) {
                    list.add(list2[i]);
                }
            }
        }
        return list.stream().toArray(String[]::new);
    }
}
// @lc code=end
