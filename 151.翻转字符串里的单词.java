/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().replaceAll(" {2,}", " ").split(" ");

        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[split.length - i - 1];
            split[split.length - i - 1] = split[i];
            split[i] = temp;
        }
        return String.join(" ", split);
    }
}
// @lc code=end

