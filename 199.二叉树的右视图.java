import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightview(root, ans, 0);
        return ans;
    }

    private void rightview(TreeNode root, List<Integer> ans, int level) {
        if (root == null) return;
        if (ans.size() == level) ans.add(root.val);

        rightview(root.right, ans, level + 1);
        rightview(root.left, ans, level + 1);
    }
}
// @lc code=end

