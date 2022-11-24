import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        // int n = gain.length;
        // int[] heights = new int[n + 1];
        // heights[0] = 0;

        // for (int i = 0; i < n; i++) {
        //     heights[i + 1] = gain[i] + heights[i];
        // }

        // return Arrays.stream(heights).max().getAsInt();

        int ans = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end
