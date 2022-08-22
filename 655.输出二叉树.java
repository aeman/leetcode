import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private String[][] res;
    
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        List<List<String>> ans = new ArrayList<>();
        fill(root, 0, 0, res[0].length);
        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.right), getHeight(node.left)) + 1;
    }

    public void fill(TreeNode root, int index, int left, int right) {
        if (root == null) return;
        res[index][(left + right) / 2] = String.valueOf(root.val);

        int mid = (left + right) / 2;
        fill(root.left, index + 1, left, mid);
        fill(root.right, index + 1, mid + 1,  right);
    }
}
// @lc code=end

