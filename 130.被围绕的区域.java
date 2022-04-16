/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        //只有四个边的0才能不被填充，先找出上下两行的0标记为*
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }

        // 再找出左右两列的0标记为*
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[m - 1][i] == 'O')
                dfs(board, m - 1, i);
        }

        // 替换中间的0为X，重新把*替换为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 到达边界，返回
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;

        if (board[i][j] == 'O')
            board[i][j] = '*';
        // 判断当前格子的上下左右是否为0，如果为0标记为*
        if (i > 1 && board[i - 1][j] == 'O')
            dfs(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            dfs(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            dfs(board, i, j - 1);
        if (j < board[0].length - 2 && board[i][j + 1] == 'O')
            dfs(board, i, j + 1);
    }
}
// @lc code=end
