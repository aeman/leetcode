import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> list, int pos, int[] nums) {
        ans.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            while (nums[pos] == nums[i]) i++;
            list.add(nums[i]);
            backtrack(ans, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

