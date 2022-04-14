import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new  HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) return true;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return false;
    }
}
// @lc code=end

