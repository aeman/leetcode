/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
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
    private int sum;
    private int maxLevel;

    public int deepestLeavesSum(TreeNode root) {
        calMaxLevelSum(root, 0);
        return sum;
    }

    public void calMaxLevelSum(TreeNode root, int level) {
        if (root == null) return;

        if (level > maxLevel) {
            sum = 0;
            maxLevel = level;
        }
        if (level == maxLevel) {
            sum += root.val;
        }

        calMaxLevelSum(root.left, level + 1);
        calMaxLevelSum(root.right, level + 1);
    }
}
// @lc code=end

