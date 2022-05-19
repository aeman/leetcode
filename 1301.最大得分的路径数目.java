import java.util.List;

/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] cs = new char[n][n];
        for (int i = 0; i < n; i++) {
            cs[i] = board.get(i).toCharArray();
        }

        int[] ans = new int[2];
        return ans;
    }
}
// @lc code=end

