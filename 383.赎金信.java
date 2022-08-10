/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabet[c - 'a'] == 0) return false; 
            alphabet[c - 'a']--;
        }

        return true;
    }
}
// @lc code=end
