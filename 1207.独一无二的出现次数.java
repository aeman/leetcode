import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!set.add(entry.getValue()))
                return false;
        }
        return true;
    }
}
// @lc code=end
