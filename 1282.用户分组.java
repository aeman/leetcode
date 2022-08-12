import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int cur = groupSizes[i];
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
            
            // 如果该位置满员了就保存该组，清空该位置
            if (map.get(cur).size() == cur) {
                ans.add(map.get(cur));
                map.remove(cur);
            }
        }
        
        return ans;
    }
}
// @lc code=end

