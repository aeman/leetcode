/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; i++) {
            ans[idx++] = i;
        }

        for (int i = n - k, j = n; i <= j; i++, j--) {
            ans[idx++] = i;
            if (i != j) ans[idx++] = j;
        }
        return ans;
    }
}
// @lc code=end

