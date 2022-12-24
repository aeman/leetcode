/*
 * @lc app=leetcode.cn id=1754 lang=java
 *
 * [1754] 构造字典序最大的合并字符串
 */

// @lc code=start
class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        while (i < m || j < n) {
            if (i < m && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

