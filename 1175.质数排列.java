/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    private final static int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int primes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) primes++;
        }
        return (int) (factorial(primes) * factorial(n - primes) % MOD);
    }

    private long factorial(int num) {
        long ret = 1;
        for (int i = 1; i <= num; i++) {
            ret *= i;
            ret %= MOD;
        }
        return ret;
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
// @lc code=end

