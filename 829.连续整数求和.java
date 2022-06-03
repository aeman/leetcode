/*
 * @lc app=leetcode.cn id=829 lang=java
 *
 * [829] 连续整数求和
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;

        // 1.前缀和超时
        // int[] preSum = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     preSum[i] = preSum[i - 1] + i;
        // }
        // for (int i = 1; i < preSum.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (preSum[i] - preSum[j] == n)
        //             ans++;
        //     }
        // }

        // 2.等差数列求和，有解的情况只能是 (2 * n) % len == 0 && (2 * n / len - len) % 2 == 0
        n *= 2;
        int len = (int) Math.sqrt(n);
        for (int i = 1; i <= len; i++) {
            int t = (n / i - i + 1) & 1;
            if (n % i == 0 && t == 0)
                ans++;
        }

        return ans;
    }
}
// @lc code=end
