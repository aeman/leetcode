import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;

        // Arrays.sort(nums);

        // for (int i = 0; i < nums.length - 3; i++) {
        // if (nums[i] == nums[i + 1]) {
        // i += 2;
        // } else {
        // return nums[i];
        // }
        // }

        // return nums[nums.length - 1];
    }
}
// @lc code=end
