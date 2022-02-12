import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1567 lang=java
 *
 * [1567] 乘积为正数的最长子数组长度
 */

// @lc code=start
class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] dpPos = new int[n];
        int[] dpNeg = new int[n];
        if (nums[0] > 0) {
            dpPos[0] = 1;
        } else if (nums[0] < 0) {
            dpNeg[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dpPos[i] = dpPos[i - 1] + 1;
                dpNeg[i] = dpNeg[i - 1] == 0 ? 0 : dpNeg[i - 1] + 1;
            } else if (nums[i] < 0) {
                dpPos[i] = dpNeg[i - 1] == 0 ? 0 : dpNeg[i - 1] + 1;
                dpNeg[i] = dpPos[i - 1] + 1;
            } else {
                dpPos[i] = 0;
                dpNeg[i] = 0;
            }
        }

        Arrays.sort(dpPos);
        return dpPos[n - 1];

    }
}
// @lc code=end
