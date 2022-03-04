import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                ans[0] = nums[i];
            } else if (nums[i] - pre > 1) {
                ans[1] = pre + 1;
            }
            pre = nums[i];
        }

        if (nums[nums.length - 1] != nums.length) {
            ans[1] = nums.length;
        }

        return ans;
    }
}
// @lc code=end
