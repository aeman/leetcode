import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution {
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        if (sb.toString().equals("123450")) return 0;

        int step = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        visited.add(sb.toString());
        queue.offer(sb.toString());

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String next : getStatus(status)) {
                    if (!visited.contains(next)) {
                        if (next.equals("123450")) return step;
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getStatus(String status) {
        List<String> nexts = new ArrayList<>();
        char[] cs = status.toCharArray();
        int zero = status.indexOf("0");
        for (int i : neighbors[zero]) {
            swap(cs, i, zero);
            nexts.add(new String(cs));
            swap(cs, i, zero);
        }
        return nexts;
    }

    private void swap(char[] cs, int i, int zero) {
        char temp = cs[i];
        cs[i] = cs[zero];
        cs[zero] = temp;
    }
}
// @lc code=end

