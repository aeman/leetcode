import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2028 lang=java
 *
 * [2028] 找出缺失的观测数据
 */

// @lc code=start
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, sum = Arrays.stream(rolls).sum();
        int total = (m + n) * mean - sum;
        int newMean = total / n, remainder = total % n;
        if (total > 6 * n || total < n)
            return new int[0];

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = newMean + (i < remainder ? 1 : 0);
        }

        return ans;
    }
}
// @lc code=end
