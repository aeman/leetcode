import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod) && i - map.get(mod) > 1) return true;
            map.putIfAbsent(mod, i);
        }
        return false;
    }
}
// @lc code=end

