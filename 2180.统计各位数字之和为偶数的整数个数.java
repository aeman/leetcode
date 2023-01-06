/*
 * @lc app=leetcode.cn id=2180 lang=java
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, n = i;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

