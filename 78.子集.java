import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> list, int pos, int[] nums) {
        ans.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(ans, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

