/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n >= 0) {
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
// @lc code=end

