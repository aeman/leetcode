import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll(), dIndex = dire.poll();
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
// @lc code=end
