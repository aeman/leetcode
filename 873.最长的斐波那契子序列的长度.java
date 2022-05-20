import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=873 lang=java
 *
 * [873] 最长的斐波那契子序列的长度
 */

// @lc code=start
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, 2);
        }
        
        int ans = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k != -1 && k < j) {
                    dp[i][j] = dp[j][k] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans == 2 ? 0 : ans;
    }
}
// @lc code=end
