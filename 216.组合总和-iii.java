import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, 9, k, n);
        return ans;
    }

    private void backtrack(int cur, int n, int k, int sum) {
        if (list.size() + (n - cur + 1) < k || list.size() > k) {
            return;
        }

        if (list.size() == k) {
            int tempSum = list.stream().mapToInt(x -> x).sum();
            if (tempSum == sum) {
                ans.add(new ArrayList<>(list));
                return;
            }
        }

        list.add(cur);
        backtrack(cur + 1, n, k, sum);
        list.remove(list.size() - 1);
        backtrack(cur + 1, n, k, sum);
    }
}
// @lc code=end
