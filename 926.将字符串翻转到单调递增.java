/*
 * @lc app=leetcode.cn id=926 lang=java
 *
 * [926] 将字符串翻转到单调递增
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1 = 0;
        for (char c : s.toCharArray()) {
            int min = Math.min(dp0, dp1);
            if (c == '1') {
                dp0++;
            } else {
                min++;
            }
            dp1 = min;
        }
        return Math.min(dp0, dp1);
    }
}
// @lc code=end

