/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1, count = 1;

        // 向left、down、right、up四个方向遍历，所有元素都遍历为循环条件
        while (count <= n * n) {
            for (int i = left; i <= right; i++) ans[up][i] = count++;
            up++;

            for (int i = up; i <= down; i++) ans[i][right] = count++;
            right--;

            if (down >= up)
                for (int i = right; i >= left; i--) ans[down][i] = count++;
            down--;

            if (right >= left)
                for (int i = down; i >= up; i--) ans[i][left] = count++;
            left++;
        }

        return ans;
    }
}
// @lc code=end
