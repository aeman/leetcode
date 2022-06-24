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
    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(0, n - 1, 0, n - 1);
        return root;
    }

    private TreeNode build(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(root.val);
        int numsLeft = index - inLeft;
        
        root.left = build(preLeft + 1, preLeft + numsLeft, inLeft, index - 1);
        root.right = build(preLeft + 1 + numsLeft, preRight, index + 1, inRight);

        return root;
    }
}
// @lc code=end

