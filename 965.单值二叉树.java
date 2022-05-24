import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    public boolean isUnivalTree(TreeNode root) {
        return bfs(root, root.val);
        // return dfs(root, root.val);
    }

    private boolean bfs(TreeNode root, int val) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val != val) return false;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return true;
    }

    private boolean dfs(TreeNode node, int val) {
        if (node.val != val) return false;

        boolean left = true, right = true;
        if (node.left != null) {
            left = dfs(node.left, val);
        }

        if (node.right != null) {
            right =  dfs(node.right, val);
        }

        return left && right;
    }
}
// @lc code=end

