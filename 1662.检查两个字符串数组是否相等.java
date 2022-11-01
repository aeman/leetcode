/*
 * @lc app=leetcode.cn id=1662 lang=java
 *
 * [1662] 检查两个字符串数组是否相等
 */

// @lc code=start
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = 0;
        for (String s : word1) {
            n += s.length();
        }
        char[] arr = new char[n];

        int idx =0;
        for (String s1 : word1) {
            for (int i = 0; i < s1.length(); i++) {
                arr[idx] = s1.charAt(i);
                idx++;
            }
        }

        idx = 0;
        for (String s2 : word2) {
            for (int i = 0; i < s2.length(); i++) {
                if (idx >= n) return false;
                if (arr[idx] != s2.charAt(i)) return false;
                idx++;
            }
        }
        if (idx != n) return false;

        return true;
    }
}
// @lc code=end

