import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > ans) ans = dp[i][j];
                }
            }
        }
        return ans;

        // 二维数组找最大值
        // return Arrays.stream(dp).flatMapToInt(IntStream::of).max().getAsInt();
    }
}
// @lc code=end

