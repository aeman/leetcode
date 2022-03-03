import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {

    private int cur;
    private List<Integer> vals = new ArrayList<>();
    
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return vals.get(cur++);
    }
    
    public boolean hasNext() {
        return cur < vals.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

