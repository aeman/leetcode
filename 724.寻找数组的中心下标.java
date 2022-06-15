import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            right = sum - left + nums[i];
            if (left == right)
                return i;
        }
        return -1;
    }
}
// @lc code=end
