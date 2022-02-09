/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n < 2)
            return n;

        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;

        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
        }

        return ans[n];
    }
}
// @lc code=end
