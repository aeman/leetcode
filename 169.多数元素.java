import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.INPUT_STREAM;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Map.Entry<Integer, Integer> major = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (major == null || entry.getValue() > major.getValue()) {
                major = entry;
            }
        }

        return major.getKey();
    }
}
// @lc code=end

