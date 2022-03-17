import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;

        Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		TreeNode root = buildTree(preorder, 0, n - 1, postorder, 0, n - 1, map);
        return root;
    }
	
	public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map) {
		if (postLeft > postRight || preLeft > preRight) return null;
		
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 关键一句
        if (preLeft == preRight) return root;
		int index = map.get(preorder[preLeft + 1]);
        int numsLeft = index - postLeft;
		
		root.left = buildTree(preorder, preLeft + 1, preLeft + numsLeft + 1, postorder, postLeft, index, map);
		root.right = buildTree(preorder, preLeft + numsLeft + 2, preRight, postorder, index + 1, postRight - 1, map);
		
		return root;
	}
}
// @lc code=end

