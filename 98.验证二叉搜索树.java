import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // inOrder(root, list);
        // for (int i = 0; i < list.size() - 1; i++) {
        // if (list.get(i) >= list.get(i + 1))
        // return false;
        // }
        // return true;

        // if (root == null)
        //     return true;
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode pre = null;
        // while (root != null || !stack.isEmpty()) {
        //     while (root != null) {
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     if (pre != null && root.val <= pre.val)
        //         return false;
        //     pre = root;
        //     root = root.right;
        // }
        // return true;

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // public void inOrder(TreeNode node, List list) {
    //     if (node != null) {
    //         inOrder(node.left, list);
    //         list.add(node.val);
    //         inOrder(node.right, list);
    //     }
    // }

    
}
// @lc code=end
