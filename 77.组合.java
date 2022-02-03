import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 1, n, k);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int depth, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = depth; i <= n; i++) {
            tempList.add(i);
            backtrack(list, tempList, i + 1, n, k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end
