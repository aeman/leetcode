import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        root.val = 1;
        queue.offer(root);
        
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), left = -1, right = -1;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left == -1) left = node.val;
                right = node.val;

                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);    
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

