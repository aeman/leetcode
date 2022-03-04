import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        return ans;

        // Arrays.sort(nums);

        // for (int i = 0; i < nums.length - 2; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         i++;
        //     } else {
        //         return nums[i];
        //     }
        // }

        // return nums[nums.length - 1];
    }
}
// @lc code=end
