/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) ans++;
        }
        return ans;
    }

    private boolean isPrime(int count) {
        if (count < 2) return false;
        for (int i = 2; i * i <= count; i++) {
            if (count % i == 0) return false;
        }
        return true;
    }
}
// @lc code=end

