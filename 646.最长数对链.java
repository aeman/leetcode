import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        int ans = 0, curr = Integer.MIN_VALUE;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end

