import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Deque<Node> stack = new ArrayDeque<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            Node cur = null;
            for (int i = 0, n = stack.size(); i < n; i++) {
                Node node = stack.poll();
                
                if (node.right != null) stack.offer(node.right);
                if (node.left != null) stack.offer(node.left);
                
                node.next = cur;
                cur = node;
            }
        }

        return root;
    }
}
// @lc code=end

