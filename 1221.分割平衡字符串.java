/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                count++;
            } else {
                count--;
            }
            if (count ==  0) ans++;
        }
        return ans;
    }
}
// @lc code=end

