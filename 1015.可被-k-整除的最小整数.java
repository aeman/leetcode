/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        
        int n = 1;
        int remain = 1 % k;
        while (remain != 0 && n <= k) {
            remain = (remain * 10 + 1) % k;
            n++;
        }
        
        return remain == 0 ? n : -1;
    }
}
// @lc code=end

