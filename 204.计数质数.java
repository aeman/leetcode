import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i])
                continue;
            ans++;
            if ((long) i * i < n) {
                for (int j = i * i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
