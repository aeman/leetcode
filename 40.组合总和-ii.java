import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int targetSum) {
        Arrays.sort(candidates); // 为去重做准备
        backtrack(candidates, 0, 0, targetSum);
        return ans;
    }

    private void backtrack(int[] candidates, int index, int sum, int targetSum) {
        if (sum == targetSum) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > targetSum) break; // 剪枝
            if (i > index && candidates[i] == candidates[i - 1]) continue; // 避免当前数字被选两次

            list.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i + 1, sum, targetSum);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
// @lc code=end
