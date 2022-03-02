import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(inorder, 0, n - 1, postorder, 0, n - 1, map);
        return root;
    }

    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map) {
        if (postLeft > postRight || inLeft > inRight) return null;

        TreeNode root = new TreeNode(postorder[postRight]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inLeft;

        root.left = build(inorder, inLeft, inRoot - 1, postorder, postLeft, postLeft + numsLeft - 1, map);
        root.right = build(inorder, inRoot + 1, inRight, postorder, postLeft + numsLeft, postRight - 1, map);

        return root;
    }
}
// @lc code=end
