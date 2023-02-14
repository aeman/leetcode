import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1124 lang=java
 *
 * [1124] 表现良好的最长时间段
 */

// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (hours[i] > 8 ? 1 : -1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (prefix[i] > 0) {
                ans = i;
            } else {
                if (!map.containsKey(prefix[i])) {
                    map.put(prefix[i], i);
                }
                if (map.containsKey(prefix[i] - 1)) {
                    ans = Math.max(ans, i - map.get(prefix[i] - 1));
                }
            }
        }
        return ans;
    }
}
// @lc code=end

