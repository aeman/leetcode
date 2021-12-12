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
        ans.add(new ArrayList<>()); // 空子集

        for (int i = 0; i < nums.length; i++) {
            int all = ans.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
// @lc code=end

