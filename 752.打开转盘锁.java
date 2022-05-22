import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
        String init = "0000";
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(init) || dead.contains(target)) return -1;

        Set<String> visited = new HashSet<>();
        visited.add(init);

        int step = 0;
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        queue1.offer(init);

        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) return step;

            for (String next : getStatus(cur)) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    queue2.offer(next);
                }
            }

            if (queue1.isEmpty()) {
                step++;
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
            }
        }

        return -1;
    }

    //获取全部下一个状态
    private List<String> getStatus(String status) {
        List<String> nexts = new ArrayList<>();
        char[] cs = status.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            cs[i] = c == '9' ? '0' : (char) (c + 1);    //左扭一下
            nexts.add(new String(cs));
            cs[i] = c == '0' ? '9' : (char) (c - 1);   //右扭一下
            nexts.add(new String(cs));
            cs[i] = c;          //恢复原状态
        }
        return nexts;
    }
}
// @lc code=end
