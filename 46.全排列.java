import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ans;
    }

    private void backtrack(int[] nums) {
        if (subset.size() == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subset.contains(nums[i])) continue;

            subset.add(nums[i]);
            backtrack(nums);
            subset.remove(subset.size() - 1);
        }
    }
}
// @lc code=end

