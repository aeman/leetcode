import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return bfs(root);
        // return dfs(root);
    }

    private int bfs(Node root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                for (Node node : queue.poll().children) {
                    queue.offer(node);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    private int dfs(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (Node node : root.children) {
            depth = Math.max(depth, dfs(node));
        }
        return depth + 1;
    }
}
// @lc code=end

