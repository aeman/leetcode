import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1817 lang=java
 *
 * [1817] 查找用户活跃分钟数
 */

// @lc code=start
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (i > 0 && (logs[i][0] == logs[i - 1][0] && logs[i][1] == logs[i - 1][1])) continue;
            map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) + 1);
        }

        int[] ans = new int[k];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[entry.getValue() - 1] += 1;
        }
        return ans;
    }
}
// @lc code=end

