import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String next : getStatus(status)) {
                    if (!dead.contains(next) && !visited.contains(next)) {
                        if (next.equals(target))
                            return step;
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
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            cs[i] = left(c);
            nexts.add(new String(cs));
            cs[i] = right(c);
            nexts.add(new String(cs));
            cs[i] = c;
        }
        return nexts;
    }

    private char right(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }

    private char left(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }
}
// @lc code=end
