import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int index) {
        if (list.size() > 1) {
            ans.add(new ArrayList<>(list));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            if (index == 0 || nums[i] >= nums[index - 1]) { // 递增序列
                list.add(nums[i]);
                backtrack(nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end
