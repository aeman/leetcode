import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1609 lang=java
 *
 * [1609] 奇偶树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean odd = true;

        while (!queue.isEmpty()) {
            int size = queue.size(), prev = odd ? 0 : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;

                if (odd && (val % 2 == 0 || val <= prev)) return false;
                if (!odd && (val % 2 != 0 || val >= prev)) return false;

                prev = val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }       

            odd = !odd;
        }

        return true;
    }
}
// @lc code=end

