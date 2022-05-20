import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return ans;
    }

    private void backtrack(int[] nums) {
        if (subset.size() == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;

            subset.add(nums[i]);
            visited[i] = true;
            backtrack(nums);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end
