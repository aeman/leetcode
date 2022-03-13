/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int ans = 0, need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need = need + 2;
                if (need % 2 == 1) {
                    ans++;
                    need--;
                }
            }
            if (c == ')') {
                need--;
                if (need == -1) {
                    ans++;
                    need = need + 2;
                }
            }
        }
        return ans + need;
    }
}
// @lc code=end
