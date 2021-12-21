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
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int postIdx;
    private int[] post;
    private Map<Integer, Integer> idxMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        postIdx = postorder.length - 1;
        idxMap = new HashMap<>();

        int idx = 0;
        for (int val : inorder) {
            idxMap.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right || postIdx == -1)
            return null;

        TreeNode root = new TreeNode(post[postIdx]);
        int index = idxMap.get(root.val);
        postIdx--;

        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);

        return root;
    }
}
// @lc code=end
