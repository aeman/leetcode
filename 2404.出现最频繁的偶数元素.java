import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2404 lang=java
 *
 * [2404] 出现最频繁的偶数元素
 */

// @lc code=start
class Solution {
    public int mostFrequentEven(int[] nums) {
        int ans = Integer.MAX_VALUE, maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int count = map.getOrDefault(nums[i], 0) + 1;
                map.put(nums[i], count);
                if (count > maxCount || (count == maxCount && nums[i] < ans)) {
                    ans = nums[i];
                    maxCount = count;
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

