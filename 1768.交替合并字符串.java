/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
        int n = Math.min(word1.length(), word2.length());
        for (int i = 0; i < n; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if (word1.length() > n) {
            sb.append(word1.substring(n, word1.length()));
        }
        if (word2.length() > n) {
            sb.append(word2.substring(n, word2.length()));
        }

        return sb.toString();
    }
}
// @lc code=end

