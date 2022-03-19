/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuffer sb) {
        if (root == null) return;

        sb.append(root.val);
        if (root.left != null && root.right == null) {
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")");
        } else if (root.left == null && root.right != null) {
            sb.append("()(");
            preorder(root.right, sb);
            sb.append(")");
        } else if (root.left != null && root.right != null)  {
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")(");
            preorder(root.right, sb);
            sb.append(")");     
        }
    }
}
// @lc code=end

