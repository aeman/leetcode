/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] 二进制矩阵中的特殊位置
 */

// @lc code=start
class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowSum = new int[n], colSum = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[j] += mat[i][j];
                colSum[i] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[j] == 1 && colSum[i] == 1) ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

