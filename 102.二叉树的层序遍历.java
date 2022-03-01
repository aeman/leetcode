import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelorder(root, ans, 0);
        return ans;
    }

    private void levelorder(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) return;

        if (ans.size() == level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);

        levelorder(root.left, ans, level + 1);
        levelorder(root.right, ans, level + 1);
    }
}
// @lc code=end

