import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2357 lang=java
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (i > 0) map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.size();
    }
}
// @lc code=end

