/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;

        int[] sum = new int[n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            sum[i + 1] = sum[i] + code[i % n];
        }

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                ans[i] = sum[i + k + 1] - sum[i + 1];
            } else {
                ans[i] = sum[i + n] - sum[i + k + n];
            }
        }
        return ans;
    }
}
// @lc code=end

