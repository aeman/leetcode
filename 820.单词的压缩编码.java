import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
class Solution {
    private int ans = 0;

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        // bfs(root);
        dfs(root, 1);   // 1代表最后那个#的长度
        return ans;
    }

    // 无法实现
    private void bfs(TrieNode root) {
        Queue<TrieNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans += size;
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                for (TrieNode child : node.children) {
                    if (child != null) queue.offer(child);
                }
            }
        }
        for (TrieNode child : root.children) {
            if (child != null) ans++;
        }
        ans--;
    }

    private void dfs(TrieNode node, int length) {
        boolean isLeaf = true;
        for (TrieNode child : node.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1);
            }
        }
        if (isLeaf) ans += length;
    }

    private void buildTrie(Solution.TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}
// @lc code=end

