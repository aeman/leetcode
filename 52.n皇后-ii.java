import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();

    public int totalNQueens(int n) {
        return backtrack(0, n);
    }

    private int backtrack(int row, int n) {
        if (row == n)
            return 1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
                continue;

            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            count += backtrack(row + 1, n);

            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
        return count;
    }
}
// @lc code=end
