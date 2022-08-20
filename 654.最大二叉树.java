import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1.bfs
        // Deque<TreeNode> stack = new ArrayDeque<>();
        // for (int n : nums){
        //     TreeNode cur = new TreeNode(n);
        //     while(!stack.isEmpty() && stack.peek().val < n){
        //         cur.left = stack.pop();
        //     }
        //     if (!stack.isEmpty()){
        //         stack.peek().right = cur;
        //     }
        //     stack.push(cur);
        // }
        // return stack.isEmpty() ? null : stack.removeLast();

        // 2.dfs
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(nums, left, maxIndex - 1);
        root.right = dfs(nums, maxIndex + 1, right);
        return root;
    }
}
// @lc code=end

