import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int d) {
        if (d == 81)
            return true;

        int i = d / 9, j = d % 9;
        if (board[i][j] != '.')
            return backtrack(board, d + 1);

        boolean[] flag = new boolean[10];
        valid(board, i, j, flag);
        for (int k = 1; k <= 9; k++) {
            if (flag[k]) {
                board[i][j] = (char) ('0' + k);
                if (backtrack(board, d + 1))
                    return true;
            }
        }

        board[i][j] = '.';
        return false;
    }

    private void valid(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.')
                flag[board[i][k] - '0'] = false;
            if (board[k][j] != '.')
                flag[board[k][j] - '0'] = false;
            int row = i / 3 * 3 + k / 3, col = j / 3 * 3 + k % 3;
            if (board[row][col] != '.')
                flag[board[row][col] - '0'] = false;
        }
    }
}
// @lc code=end
