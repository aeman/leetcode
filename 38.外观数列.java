/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIndex(s);
        }
        return s;
    }

    private String countIndex(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count).append(c);
        return sb.toString();
    }
}
// @lc code=end

