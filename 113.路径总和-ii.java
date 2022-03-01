import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<Integer>(), ans);
        return ans;   
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;

        path.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, sum - root.val, path, ans);
            dfs(root.right, sum - root.val, path, ans);
        }

        path.remove(path.size() - 1);
    }
}
// @lc code=end

