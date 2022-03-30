import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();

        List<Integer>[] pos = new List[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = new ArrayList<>();
        }

        // 记录单词的位置信息
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
// @lc code=end
