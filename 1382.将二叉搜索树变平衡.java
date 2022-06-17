import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
    private List<Integer> ans = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);  //中序遍历成有序数组
        return build(ans, 0, ans.size() - 1);   //有序数组转成平衡二叉树
    }

    private TreeNode build(List<Integer> list, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, left, mid - 1);
        root.right = build(list, mid + 1, right);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}
// @lc code=end

