/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
class Solution {
    private Trie root = new Trie();
    private int HIGH_BIT = 30;  //将数组中的元素看成长度为31的字符串，字符串只包含0和1
    
    public int findMaximumXOR(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 1; i < n; i++) {
            add(nums[i - 1]);
            ans = Math.max(ans, check(nums[i]));
        }
        return ans;
    }

    private int check(int num) {
        Trie cur = root;
        int ret = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cur.right != null) {
                    cur = cur.right;
                    ret = ret * 2 + 1;
                } else {
                    cur = cur.left;
                    ret = ret * 2;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                    ret = ret * 2 + 1;
                } else {
                    cur = cur.right;
                    ret = ret * 2;
                }
            }
        }
        return ret;
    }

    private void add(int num) {
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cur.left == null) cur.left = new Trie();
                cur = cur.left;
            } else {
                if (cur.right == null) cur.right = new Trie();
                cur = cur.right;
            }
        }
    }

    class Trie {
        Trie left = null;
        Trie right = null;
    }
}
// @lc code=end

