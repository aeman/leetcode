/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left), right = dfs(root.right);

        int left2 = 0, right2 = 0;
        if (root.left != null && root.val == root.left.val) left2 = left + 1;
        if (root.right != null && root.val == root.right.val) right2 = right + 1;

        ans = Math.max(ans, left2 + right2);
        return Math.max(left2, right2);
    }
}
// @lc code=end

