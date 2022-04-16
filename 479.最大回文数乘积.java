/*
 * @lc app=leetcode.cn id=479 lang=java
 *
 * [479] 最大回文数乘积
 */

// @lc code=start
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;

        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            // 构造回文数pal
            long pal = i;
            for (int j = i; j > 0; j /= 10) {
                pal = pal * 10 + j % 10;
            }

            // 测试是否满足条件
            for (long j = max; j * j >= pal; j--) {
                if (pal % j == 0) {
                    return (int) (pal % 1337);
                }
            }
        }

        return 0;
    }
}
// @lc code=end
