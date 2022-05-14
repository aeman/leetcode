import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=909 lang=java
 *
 * [909] 蛇梯棋
 */

// @lc code=start
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, end = n * n;
        boolean[] visited = new boolean[n * n + 1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = p[0] + i;
                if (next > end) break;    //超出边界

                int[] rc = id2rc(next, n);  //获取下一步的行列
                if (board[rc[0]][rc[1]] > 0) {  //存在蛇或者梯子
                    next = board[rc[0]][rc[1]];
                }

                if (next == end) return p[1] + 1;   //到达终点

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, p[1] + 1});  //扩展新状态
                }
            }
        }

        return -1;
    }

    private int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
// @lc code=end

