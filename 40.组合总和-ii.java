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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                // 跳过重复的元素
                if (i > idx && candidates[i] == candidates[i-1]) continue;
                arrayList.add(candidates[i]);
                backtrack(list, arrayList, candidates, target - candidates[i], i + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}
// @lc code=end

