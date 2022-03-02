import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, n - 1, inorder, 0, n - 1, map);
        return root;
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inLeft;
        
        root.left = build(preorder, preLeft + 1, preLeft + numsLeft, inorder, inLeft, inRoot - 1, map);
        root.right = build(preorder, preLeft + numsLeft + 1, preRight, inorder, inRoot + 1, inRight, map);

        return root;
    }
}
// @lc code=end

