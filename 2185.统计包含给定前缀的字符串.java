/*
 * @lc app=leetcode.cn id=2185 lang=java
 *
 * [2185] 统计包含给定前缀的字符串
 */

// @lc code=start
class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

