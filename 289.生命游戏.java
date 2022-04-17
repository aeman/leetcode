/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] % 10 == 1) {
                    if (i > 0 && j > 0)
                        board[i - 1][j - 1] += 10;
                    if (i > 0)
                        board[i - 1][j] += 10;
                    if (j > 0)
                        board[i][j - 1] += 10;
                    if (i < m - 1&& j < n - 1)
                        board[i + 1][j + 1] += 10;
                    if (i < m - 1)
                        board[i + 1][j] += 10;
                    if (j < n - 1)
                        board[i][j + 1] += 10;
                    if (i > 0 && j < n - 1)
                        board[i - 1][j + 1] += 10;
                    if (i < m - 1&& j > 0)
                        board[i + 1][j - 1] += 10;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = board[i][j] % 10, cells = board[i][j] / 10;
                if (live == 1) {
                    if (cells < 2) {
                        board[i][j] = 0;
                    } else if (cells == 2 || cells == 3) {
                        board[i][j] = 1;
                    } else if (cells > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (cells == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                        
                }
            }
        }
    }
}
// @lc code=end
