import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    // private Map<TreeNode, Integer> map = new HashMap<>();
    
    public int rob(TreeNode root) {
        // 1.memo
        // if (root == null) return 0;
        // if (map.containsKey(root)) return map.get(root);

        // int money = root.val;

        // if (root.left != null) {
        //     money += rob(root.left.left) + rob(root.left.right);
        // }
        // if (root.right != null) {
        //     money += rob(root.right.left) + rob(root.right.right);
        // }

        // int max = Math.max(money, rob(root.left) + rob(root.right));
        // map.put(root, max);
        // return max;

        // 2.dp
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);  // 0表示不抢，1表示抢
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = root.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }
}
// @lc code=end

