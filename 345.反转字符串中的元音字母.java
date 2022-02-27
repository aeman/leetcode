/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        int begin = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();

        while (begin < end) {
            while (begin < s.length() && !isVowel(arr[begin]))
                begin++;
            while (end > 0 && !isVowel(arr[end]))
                end--;

            if (begin < end) {
                char temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
                begin++;
                end--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
// @lc code=end
