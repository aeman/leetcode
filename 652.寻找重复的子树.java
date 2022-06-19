import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        traverse(root, list, map);
        return list;
    }

    private String traverse(TreeNode root, List<TreeNode> list, Map<String, Integer> map) {
        if (root == null) return "#";
        String left = traverse(root.left, list, map), right = traverse(root.right, list, map);
        String key = root.val + "," + left + "," + right;
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2)  {
            list.add(root);
        }
        return key;
    }
}
// @lc code=end

