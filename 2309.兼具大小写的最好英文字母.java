/*
 * @lc app=leetcode.cn id=2309 lang=java
 *
 * [2309] 兼具大小写的最好英文字母
 */

// @lc code=start
class Solution {
    public String greatestLetter(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c) && arr[c - 'a'] != 1 && arr[c - 'a'] != 3) {
                arr[c - 'a'] += 1;
            } else if (Character.isUpperCase(c) && arr[c - 'A'] != 2 && arr[c - 'A'] != 3) {
                arr[c - 'A'] += 2;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 3) return String.valueOf((char) (i + 'A'));
        }
        return "";
    }
}
// @lc code=end

