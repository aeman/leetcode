import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int total = Arrays.stream(nums).sum(), curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr += nums[i];
            ans.add(nums[i]);
            if (curr > total - curr) break;
        }
        return ans;
    }
}
// @lc code=end

