/*
 * @lc app=leetcode.cn id=2055 lang=java
 *
 * [2055] 蜡烛之间的盘子
 */

// @lc code=start
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                sum++;
            preSum[i] = sum;
        }

        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|')
                l = i;
            left[i] = l;
        }

        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                r = i;
            right[i] = r;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = right[queries[i][0]], y = left[queries[i][1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }

        return ans;
    }

    // private int find(String s) {
    // int begin = -1, end = -1;
    // for (int i = 0; i < s.length(); i++) {
    // if (s.charAt(i) == '|') {
    // if (begin == -1) begin = i;
    // end = i;
    // }
    // }
    // if (begin == end) return 0;
    // return count(s.substring(begin, end));
    // }

    // private int count(String s) {
    // int count = 0;
    // for (char c : s.toCharArray()) {
    // if (c == '*') count++;
    // }
    // return count;
    // }
}
// @lc code=end
