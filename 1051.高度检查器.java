import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
         int[] expected = Arrays.copyOfRange(heights, 0, n);
        Arrays.sort(expected);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) ans++;
        }
        return ans;
    }
}
// @lc code=end

