/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {   // 偶数
                ans++;
                n /= 2;
            } else if (n % 4 == 1) {    //奇数 除以4余1的情况
                ans += 2;
                n /= 2;
            } else {        //奇数 除以4余3的情况
                if (n == 3) {
                    ans += 2;
                    n =1;
                } else {
                    ans += 2;
                    n = n / 2 +1;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

