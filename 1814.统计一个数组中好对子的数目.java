import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1814 lang=java
 *
 * [1814] 统计一个数组中好对子的数目
 */

// @lc code=start
class Solution {
    private static int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int temp = num, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            ans = (ans + map.getOrDefault(num - j, 0)) % MOD;
            map.put(num - j, map.getOrDefault(num - j, 0) + 1); 
        }
        return ans;
    }
}
// @lc code=end

