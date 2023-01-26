/*
 * @lc app=leetcode.cn id=1663 lang=java
 *
 * [1663] 具有给定数值的最小字符串
 */

// @lc code=start
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            ans.append((char) ('a' + lower - 1));
        }
        return ans.toString();
    }
}
// @lc code=end

