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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> arrayList, int[] candidates, int target, int idx) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(arrayList));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                arrayList.add(candidates[i]);
                backtrack(list, arrayList, candidates, target - candidates[i], i);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}
// @lc code=end

