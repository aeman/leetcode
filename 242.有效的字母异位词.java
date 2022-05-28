import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i) - 'a'] -= 1;
        }
        // 数组每一位都为0，说明s和t互为异位词
        return Arrays.equals(letters, new int[26]);
    }
}
// @lc code=end

