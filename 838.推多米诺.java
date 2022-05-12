/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[][] records = new int[n][2];
        char[] cs = dominoes.toCharArray();

        for (int i = 0, cur = Integer.MIN_VALUE; i < n; i++) {
            if (cs[i] == 'R')
                cur = i;
            else if (cs[i] == 'L')
                cur = Integer.MIN_VALUE;
            records[i][1] = cur == Integer.MIN_VALUE ? Integer.MAX_VALUE : i - cur;
        }

        for (int i = n - 1, cur = Integer.MAX_VALUE; i >= 0; i--) {
            if (cs[i] == 'L')
                cur = i;
            else if (cs[i] == 'R')
                cur = Integer.MAX_VALUE;
            records[i][0] = cur == Integer.MAX_VALUE ? Integer.MAX_VALUE : cur - i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (records[i][0] == records[i][1]) {
                sb.append('.');
            } else if (records[i][0] > records[i][1]) {
                sb.append('R');
            } else if (records[i][0] < records[i][1]) {
                sb.append('L');
            }
        }
        return sb.toString();
    }
}
// @lc code=end
