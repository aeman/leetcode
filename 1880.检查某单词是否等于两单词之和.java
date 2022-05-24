/*
 * @lc app=leetcode.cn id=1880 lang=java
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = parse(firstWord), b = parse(secondWord), c = parse(targetWord);
        return a + b == c ? true : false;
    }

    private int parse(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c - 'a');
        }
        return Integer.parseInt(sb.toString());
    }
}
// @lc code=end
