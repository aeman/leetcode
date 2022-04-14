/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                char ch = Character.toLowerCase(c);
                sb.append(ch);
            }
        }
        return isPalindromeStr(sb.toString());
    }

    private boolean isPalindromeStr(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

