import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (String str : arr) {
            sb.append(reverse(str)).append(" ");
        }
        return sb.substring(0, s.length());
    }

    private String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char temp = str.charAt(left);
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}
// @lc code=end
