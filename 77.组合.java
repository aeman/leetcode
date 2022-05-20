import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }

    private void backtrack(int index, int n, int k) {
        // 剪枝：subset 长度加上区间 [index, n] 的长度小于 k，不可能构造出长度为 k 的 subset
        if (subset.size() + (n - index + 1) < k) {
            return;
        }
        if (subset.size() == k) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // if (index > n) return;
        
        backtrack(index + 1, n, k);
        subset.add(index);
        backtrack(index + 1, n, k);
        subset.remove(subset.size() - 1);
    }
}
// @lc code=end
