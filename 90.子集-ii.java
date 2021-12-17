import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();// 存放符合条件结果的集合
        List<Integer> temp = new ArrayList<>();// 用来存放符合条件结果
        backtrack(false, 0, nums, temp, ans);
        
        // int n = nums.length;
        // for (int mask = 0; mask < (1 << n); ++mask) {
        //     temp.clear();
        //     boolean flag = true;
        //     for (int i = 0; i < n; ++i) {
        //         if ((mask & (1 << i)) != 0) {
        //             if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
        //                 flag = false;
        //                 break;
        //             }
        //             temp.add(nums[i]);
        //         }
        //     }
        //     if (flag) {
        //         ans.add(new ArrayList<Integer>(temp));
        //     }
        // }
        
        return ans;
    }

    public void backtrack(boolean isPre, int pos, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        backtrack(false, pos + 1, nums, temp, ans);
        if (pos > 0 && nums[pos] == nums[pos - 1] && !isPre) return;

        temp.add(nums[pos]);
        backtrack(true, pos + 1, nums, temp, ans);
        temp.remove(temp.size() - 1);
    }
}
// @lc code=end

