import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, TreeNode> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findAns(target, null, 0, k);
        return ans;
    }

    private void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) return;

        if (depth == k) {
            ans.add(node.val);
            return;
        }

        if (node.left != from) findAns(node.left, node, depth + 1, k);
        if (node.right != from) findAns(node.right, node, depth + 1, k);
        if (map.get(node.val) != from) findAns(map.get(node.val), node, depth + 1, k);
    }

    private void findParent(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            findParent(root.right);
        }
    }
}
// @lc code=end

