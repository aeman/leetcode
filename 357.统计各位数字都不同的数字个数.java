/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 9 * factor(i - 1);
        }
        return dp[n];
    }

    private int factor(int i) {
        int ret = 1;
        for (int j = 0; j < i; j++) {
            ret *= (9 - j);
        }
        return ret;
    }
}
// @lc code=end

