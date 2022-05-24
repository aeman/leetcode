/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
class Solution {
    // private Trie root = new Trie();
    private int HIGH_BIT = 30;  //将数组中的元素看成长度为31的字符串，字符串只包含0和1
    
    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);

        int ans = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            ans = Math.max(ans, xor);
        }
        return ans;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1; //获取bit位，0 or 1
                if (node.children[bit] == null) node.children[bit] = new TrieNode();
                node = node.children[bit];
            }
        }
        return root;
    }

    // private int check(int num) {
    //     Trie cur = root;
    //     int ret = 0;
    //     for (int i = HIGH_BIT; i >= 0; i--) {
    //         int bit = (num >> i) & 1;
    //         if (bit == 0) {
    //             if (cur.right != null) {
    //                 cur = cur.right;
    //                 ret = ret * 2 + 1;
    //             } else {
    //                 cur = cur.left;
    //                 ret = ret * 2;
    //             }
    //         } else {
    //             if (cur.left != null) {
    //                 cur = cur.left;
    //                 ret = ret * 2 + 1;
    //             } else {
    //                 cur = cur.right;
    //                 ret = ret * 2;
    //             }
    //         }
    //     }
    //     return ret;
    // }

    // private void add(int num) {
    //     Trie cur = root;
    //     for (int i = HIGH_BIT; i >= 0; i--) {
    //         int bit = (num >> i) & 1;
    //         if (bit == 0) {
    //             if (cur.left == null) cur.left = new Trie();
    //             cur = cur.left;
    //         } else {
    //             if (cur.right == null) cur.right = new Trie();
    //             cur = cur.right;
    //         }
    //     }
    // }

    class TrieNode {
        TrieNode[] children = new TrieNode[2];  // 0 or 1
    }
}
// @lc code=end

