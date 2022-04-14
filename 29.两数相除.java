/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) flag = false;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long lans = ldivide(ldividend, ldivisor);
        
        int ans = 0;
        if (lans > Integer.MAX_VALUE) {
            ans = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = flag ? (int) lans : (int) -lans;
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        
        long sum = ldivisor, multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
// @lc code=end

