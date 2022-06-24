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
    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(0, n - 1, 0, n - 1);
        return root;
    }

    private TreeNode build(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) return null;

        TreeNode root = new TreeNode(postorder[postRight]);
        int index = map.get(root.val);
        int numsLeft = index - inLeft;

        root.left = build(inLeft, index - 1, postLeft, postLeft + numsLeft - 1);
        root.right = build(index + 1, inRight, postLeft + numsLeft, postRight - 1);

        return root;
    }
}
// @lc code=end
