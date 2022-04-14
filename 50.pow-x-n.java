/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double ans = 1.0;
        long ln = n;
        if (ln < 0) {
            ln = -ln;
            x = 1 / x;
        }
        while (ln > 0) {
            if ((ln & 1) == 1) ans *= x;
            x *= x;
            ln >>= 1;
        }
        return ans;
    }
}
// @lc code=end

