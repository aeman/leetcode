import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1604 lang=java
 *
 * [1604] 警告一小时内使用相同员工卡大于等于三次的人
 */

// @lc code=start
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyTime.length; i++) {
            map.putIfAbsent(keyName[i], new ArrayList<>());
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 
                + Integer.parseInt(keyTime[i].substring(3));
            map.get(keyName[i]).add(time);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String,List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
// @lc code=end

