/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length - 1;
        return dfs(0, 0, n, n, grid);
    }

    private Node dfs(int r0, int c0, int r1, int c1, int[][] grid) {
        boolean flag = true;
        int t = grid[r0][c0];
        for (int i = r0; i <= r1 && flag; i++) {
            for (int j = c0; j <= c1 && flag; j++) {
                if (grid[i][j] != t) flag = false;
            }
        }
        if (flag) return new Node(t == 1, true);

        Node root = new Node(t == 1, false);
        int x = r1 - r0 + 1, y = c1 - c0 + 1;
        root.topLeft = dfs(r0, c0, r0 + x / 2 - 1, c0 + y / 2 - 1, grid);
        root.topRight = dfs(r0, c0 + y / 2, r0 + x / 2 - 1, c1, grid);
        root.bottomLeft = dfs(r0 + x / 2, c0, r1, c0 + y / 2 - 1, grid);
        root.bottomRight = dfs(r0 + x / 2, c0 + y / 2, r1, c1, grid);
        return root;
    }
}
// @lc code=end

