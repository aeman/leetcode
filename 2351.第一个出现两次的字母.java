/*
 * @lc app=leetcode.cn id=2351 lang=java
 *
 * [2351] 第一个出现两次的字母
 */

// @lc code=start
class Solution {
    public char repeatedCharacter(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
            if (map[c - 'a'] == 2) return c;
        }
        return '0';
    }
}
// @lc code=end

