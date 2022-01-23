import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //当数组只有一个元素时，不可能连续，前缀和设为-1

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
             } else {
                count++;
             }
       
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
}
// @lc code=end

