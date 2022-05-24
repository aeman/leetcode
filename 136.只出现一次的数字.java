import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 两个相同的数字异或的结果是0，将数组中所有数字异或，最终的结果就是那个唯一只出现一次的数字
        // int ans = 0;
        // for(int num : nums) {
        //     ans ^= num; 
        // }
        // return ans;

        Arrays.sort(nums);
        int left = 0, right = nums.length /  2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid *  2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 1] == nums[i - 2]) return nums[i];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
// @lc code=end
