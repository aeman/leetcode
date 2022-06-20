/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[2];

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                pos[1]++;
            } else if (c == 'D') {
                pos[1]--;
            } else if (c == 'L') {
                pos[0]--;
            } else {
                pos[0]++;
            }
        }

        return pos[0] == 0 && pos[1] == 0;
    }
}
// @lc code=end
