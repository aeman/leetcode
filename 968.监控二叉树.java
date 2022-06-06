/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
    public int minCameraCover(TreeNode root) {
        int[] arr = dfs(root);
        return arr[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE / 2, 0,  0};

        int[] left = dfs(root.left), right = dfs(root.right);

        // 状态 a: root 必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
        // 状态 b: 覆盖整棵树需要的摄像头数目，无论 root 是否放置摄像头。
        // 状态 c: 覆盖两棵子树需要的摄像头数目，无论节点 root 本身是否被监控到。 
        int[] arr = new int[3];
        arr[0] = left[2] + right[2] + 1;
        arr[1] = Math.min(arr[0], Math.min(left[0] + right[1], left[1] + right[0]));
        arr[2] = Math.min(arr[0], left[1] + right[1]);
        return arr;
    }
}
// @lc code=end

