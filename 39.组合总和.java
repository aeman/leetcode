import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target);
        return ans;
    }

    private void backtrack(int[] candidates, int index, int sum, int targetSum) {
        if (sum == targetSum) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > targetSum) break; // 剪枝

            list.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, sum, targetSum);   // 可以重复，不用i+1
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
// @lc code=end
