/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i + m <= n; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) return i;
        }

        return -1;
    }
}
// @lc code=end
