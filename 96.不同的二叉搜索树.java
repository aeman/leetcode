import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        // 1.dp
        // int[] dp = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 1;

        // for (int i = 2; i <= n; ++i) {
        //     for (int j = 1; j <= i; ++j) {
        //         dp[i] += dp[j - 1] * dp[i - j];
        //     }
        // }

        // return dp[n];

        // 2.recursion
        if (n == 0 || n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            sum += left * right;
        }
        map.put(n, sum);

        return sum;
    }
}
// @lc code=end
