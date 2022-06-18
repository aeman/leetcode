import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(0, n);
        return ans;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
                continue;

            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            String rowString = new String(arr);
            list.add(rowString);
            
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            backtrack(row + 1, n);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
// @lc code=end
