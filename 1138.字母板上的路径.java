/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int i = (c - 'a') / 5, j = (c - 'a') % 5;
            if (i < x) {
                for (int k = 0; k < x - i; k++) {
                    sb.append('U');
                }
            }
            if (j < y) {
                for (int k = 0; k < y - j; k++) {
                    sb.append('L');
                }
            }
            if (i > x) {
                for (int k = 0; k < i - x; k++) {
                    sb.append('D');
                }
            }
            if (j > y) {
                for (int k = 0; k < j - y; k++) {
                    sb.append('R');
                }
            }
            sb.append('!');
            x = i;
            y = j;
        }
        return sb.toString();
    }
}
// @lc code=end

