import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    private boolean[] used;
    private int[] factorial;

    public String getPermutation(int n, int k) {
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        // 构造阶乘数组
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder path = new StringBuilder();
        backtrack(0, path, n, k);
        return path.toString();
    }

    private void backtrack(int depth, StringBuilder path, int n, int k) {
        if (depth == n)
            return;
        int cnt = factorial[n - 1 - depth];

        for (int i = 1; i <= n; i++) {
            if (used[i])
                continue;
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            backtrack(depth + 1, path, n, k);
            return;
        }
    }
}
// @lc code=end
