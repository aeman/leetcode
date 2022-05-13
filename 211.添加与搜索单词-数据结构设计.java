/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new Node();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, Node node, int idx) {
        int n = word.length();
        if (n == idx) return node.isEnd;

        char c = word.charAt(idx);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && dfs(word, node.children[i], idx + 1)) return true;
            }
            return false;
        } else {
            int idx2 = c - 'a';
            if (node.children[idx2] == null) return false;
            return dfs(word, node.children[idx2], idx + 1);
        }
    }

    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

