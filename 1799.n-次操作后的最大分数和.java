/*
 * @lc app=leetcode.cn id=1799 lang=java
 *
 * [1799] N 次操作后的最大分数和
 */

// @lc code=start
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] dp = new int[1 << n];
        int[][] gcdTmp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int all = 1 << n;
        for (int s = 1; s < all; ++s) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) {
                continue;
            }
            for (int i = 0; i < n; ++i) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < n; ++j) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
    }

    private int gcd(int i, int j) {
        while (j != 0) {
            int temp = i;
            i = j;
            j = temp % j;
        }
        return i;
    }
}
// @lc code=end
