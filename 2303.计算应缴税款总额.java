/*
 * @lc app=leetcode.cn id=2303 lang=java
 *
 * [2303] 计算应缴税款总额
 */

// @lc code=start
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        int lower = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            int tax = (Math.min(income, upper) - lower) * percent;
            ans += tax;
            if (income <= upper) break;
            lower = upper;
        }
        return ans / 100;
    }
}
// @lc code=end

