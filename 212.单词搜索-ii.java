import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, set);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, Trie trie, int i, int j, Set<String> set) {
        char c = board[i][j];
        if (trie.children[c - 'a'] == null) return;
        
        trie = trie.children[c - 'a'];
        if (!trie.word.equals("")) {
            set.add(trie.word);
        }

        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                dfs(board, trie, x, y, set);
            }
        }
        board[i][j] = c;
    }

    class Trie {
        String word = "";
        private Trie[] children = new Trie[26];

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (children[index] == null) {
                    children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            this.word = word;
        }
    }
}
// @lc code=end

