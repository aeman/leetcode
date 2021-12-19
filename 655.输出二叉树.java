import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.right), getHeight(node.left)) + 1;
    }

    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null) return;
        res[i][(l + r) / 2] = String.valueOf(root.val);
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2,  r);
    }
}
// @lc code=end

