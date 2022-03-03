import java.util.ArrayDeque;
import java.util.Deque;

import com.sun.corba.se.impl.orbutil.graph.Node;

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
            Node pre = null;
            for (int i = 0, n = stack.size(); i < n; i++) {
                Node cur = stack.pollFirst();
                
                if (cur.right != null) stack.offer(cur.right);
                if (cur.left != null) stack.offer(cur.left);
                
                cur.next = pre;
                pre = cur;
            }
        }

        return root;
    }
}
// @lc code=end

