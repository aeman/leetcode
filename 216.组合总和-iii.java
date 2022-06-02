import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, 0, k, n);
        return ans;
    }

    private void backtrack(int index, int sum, int k, int targetSum) {
        // 剪枝
        if (list.size() + (9 - index + 1) < k) {
            return;
        }

        if (list.size() == k) {
            // int curSum = list.stream().mapToInt(x -> x).sum();
            if (sum == targetSum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            list.add(i);
            sum += i;
            backtrack(i + 1, sum, k, targetSum);
            list.remove(list.size() - 1);
            sum -= i;
        }
        // list.add(start);
        // backtrack(start + 1, end, k);
        // list.remove(list.size() - 1);
        // backtrack(start + 1, end, k);
    }
}
// @lc code=end
