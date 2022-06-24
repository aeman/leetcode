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
	private int[] preorder;
	private Map<Integer, Integer> map = new HashMap<>();

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		this.preorder = preorder;
        int n = preorder.length;

		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		TreeNode root = build(0, n - 1, 0, n - 1);
        return root;
    }
	
	private TreeNode build(int preLeft, int preRight, int postLeft, int postRight) {
		if (preLeft > preRight || postLeft > postRight) return null;
		
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 关键一句
        if (preLeft == preRight) return root;
		int index = map.get(preorder[preLeft + 1]);
        int numsLeft = index - postLeft + 1;
		
		root.left = build(preLeft + 1, preLeft + numsLeft, postLeft, index);
		root.right = build(preLeft + 1 + numsLeft, preRight, index + 1, postRight - 1);
		
		return root;
	}
}
// @lc code=end

