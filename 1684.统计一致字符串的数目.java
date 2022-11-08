/*
 * @lc app=leetcode.cn id=1684 lang=java
 *
 * [1684] 统计一致字符串的数目
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0, map[] = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            map[allowed.charAt(i) - 'a'] = 1;
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (map[word.charAt(i) - 'a'] == 0) break;
                if (i == word.length() - 1) ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

