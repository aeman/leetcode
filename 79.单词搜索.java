/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //匹配单词首字母，然后回溯算法匹配剩下的字母
                if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        //单词全部匹配，返回true
        if (index == word.length()) return true;

        //超出边界或者字母不匹配或者已经访问过
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 ||
        board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (dfs(board, word, i-1, j, index+1) || 
        dfs(board, word, i+1, j, index+1) ||
        dfs(board, word, i, j-1, index+1) ||
        dfs(board, word, i, j+1, index+1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
// @lc code=end

