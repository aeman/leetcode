/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] letters = new int[26];
        int left = 0, right = 0, maxLetter = 0;

        while (right < s.length()) {
            letters[s.charAt(right) - 'A']++;
            maxLetter = Math.max(maxLetter, letters[s.charAt(right) - 'A']);
            if (right - left + 1 - maxLetter > k) {
                letters[s.charAt(left) - 'A']--;
                left++; 
            }
            right++;
        }

        return right - left;
    }
}
// @lc code=end

