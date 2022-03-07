/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        StringBuffer ans = new StringBuffer();

        char sign = '+';
        if (num < 0) {
            sign = '-';
            num *= -1;
        }

        if (num == 0) return "0";

        while (num != 0) {
            ans.append(num % 7);
            num /= 7;
        }

        if (sign == '-') ans.append('-');

        return ans.reverse().toString();
    }
}
// @lc code=end

