/*
 * @lc app=leetcode.cn id=809 lang=java
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String t : words) {
            if (expand(s, t)) ans++;
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) return false;

            int countI = 0, countJ = 0;
            char c = s.charAt(i);
            while (i < s.length() && s.charAt(i) == c) {
                countI++;
                i++;
            }
            while (j < t.length() && t.charAt(j) == c) {
                countJ++;
                j++;
            }

            if (countI < countJ) return false;
            if (countI != countJ && countI < 3) return false;
        }
        return i == s.length() && j == t.length();
    }
}
// @lc code=end

