/*
 * @lc app=leetcode.cn id=1759 lang=java
 *
 * [1759] 统计同构子字符串的数目
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;

    public int countHomogenous(String s) {
        long ans = 0, count = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 1;
                prev = c;
            }
        }
        ans += count * (count + 1) / 2;
        return (int) (ans % MOD);
    }
}
// @lc code=end

