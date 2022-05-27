/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1, n = b.length() - 1, carry = 0;

        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int digitA = 0, digitB = 0;
            if (m >= 0) {
                digitA = a.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                digitB = b.charAt(n) - '0';
                n--;
            }

            int sum = digitA + digitB + carry;
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }

        // 别忘了最后一位的进位
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

