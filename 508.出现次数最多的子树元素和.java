import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    private Map<Integer, Integer> map = new HashMap<>();
    private int max = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value == max) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
// @lc code=end

