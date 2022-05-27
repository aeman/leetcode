import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 1.排序判断
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 3; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         i += 2;
        //     } else {
        //         return nums[i];
        //     }
        // }
        // return nums[nums.length - 1];

        // 2.位运算
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);  // 判断第i位上的数字是否为1
            }
            if (total % 3 != 0) {   // 判断第i位上的数字是否3的倍数
                ans |= (1 << i);    // 如果不是，说明是独立数字，设置第i位
            }
        }
        return ans;
    }
}
// @lc code=end
