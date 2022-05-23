import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // 1. HashSet
        // Set<String> set = new HashSet<>(dictionary);

        // StringBuilder sb = new StringBuilder();
        // for (String word : sentence.split(" ")) {
        //     String prefix = "";
        //     for (int i = 1; i <= word.length(); i++) {
        //         prefix = word.substring(0, i);
        //         if (set.contains(prefix)) break;
        //     }
        //     sb.append(prefix).append(" ");
        // }

        // return sb.toString().substring(0, sb.length() - 1);

        // 2. TrieTree
        TrieNode root = buildTree(dictionary);

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null || node.word != null) break;
                node = node.children[c - 'a'];
            }
            sb.append(node.word != null ? node.word : word).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private TrieNode buildTree(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
// @lc code=end

