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
        map.put(0, -1); // 恰好可以被k整除，余数为0

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (map.containsKey(reminder) && i - map.get(reminder) >= 2) return true;
            map.putIfAbsent(reminder, i);
        }
        return false;
    }
}
// @lc code=end

