import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0, pre = 0;

        // int[] preSum = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     preSum[i] = preSum[i - 1] + nums[i - 1];
        // }

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (preSum[i] - preSum[j] == k)
        //             ans++;
        //     }
        // }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                ans += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        
        return ans;
    }
}
// @lc code=end
