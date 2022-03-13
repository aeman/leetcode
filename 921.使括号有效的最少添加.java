/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') need++;
            if (c ==  ')') {
                need--;
                if (need == -1) {
                    ans++;
                    need++;
                }
            }
        }
        return ans + need;
    }
}
// @lc code=end

