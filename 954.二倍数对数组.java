import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=954 lang=java
 *
 * [954] 二倍数对数组
 */

// @lc code=start
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 0只能和0匹配，如果0的个数为奇数，则返回false
        if (map.getOrDefault(0, 0) % 2 != 0)
            return false;

        // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = map.keySet().stream().collect(Collectors.toList());
        Collections.sort(list, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int i : list) {
            if (map.getOrDefault(2 * i, 0) < map.get(i))
                return false;
            map.put(2 * i, map.getOrDefault(2 * i, 0) - map.get(i));
        }

        return true;
    }
}
// @lc code=end
