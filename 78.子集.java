import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return ans;
    }

    public void backtrack(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        backtrack(index + 1, nums);
        subset.add(nums[index]);
        backtrack(index + 1, nums);
        subset.remove(subset.size() - 1);
    }
}
// @lc code=end

