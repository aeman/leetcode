import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleResult;

/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        backtrack(root, new StringBuilder(), list);

        int ans = 0;
        for (String s : list) {
            ans += Integer.parseInt(s, 2);
        }
        return ans;
    }

    private void backtrack(TreeNode root, StringBuilder sb, List<String> list) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            backtrack(root.left, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            backtrack(root.right, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

