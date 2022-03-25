/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] newImg = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newImg[i][j] = smoothe(img, i, j, m, n);
            }
        }

        return newImg;
    }

    private int smoothe(int[][] img, int x, int y, int m, int n) {
        int num = 0, sum = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < m && j < n) {
                    num++;
                    sum += img[i][j];
                }
            }
        }

        return sum / num;
    }
}
// @lc code=end
