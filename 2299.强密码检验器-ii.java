/*
 * @lc app=leetcode.cn id=2299 lang=java
 *
 * [2299] 强密码检验器 II
 */

// @lc code=start
class Solution {
    private static String spString = "!@#$%^&*()-+";

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean upper = false, lower = false, digit = false, special = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false;
            if (c >= 'A' && c <= 'Z') upper = true;
            if (c >= 'a' && c <= 'z') lower = true;
            if (c >= '0' && c <= '9') digit = true;
            if (spString.indexOf(c) >= 0) special = true;        }

        return upper && lower && digit && special;
    }
}
// @lc code=end

