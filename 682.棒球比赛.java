import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        int index = 0;
        int[] ans = new int[ops.length];

        for (String s : ops) {
            if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') {
                ans[index++] = Integer.parseInt(s);
            } else if (s.equals("+")) {
                ans[index] = ans[index - 1] + ans[index - 2];
                index++;
            } else if (s.equals("D")) {
                ans[index] = ans[index - 1] * 2;
                index++;
            } else if (s.equals("C")) {
                ans[index - 1] = 0;
                index--;
            }
        }
        return Arrays.stream(ans).sum();
    }
}
// @lc code=end
