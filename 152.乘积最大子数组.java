import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // if (nums.length == 0) return 0;

        // int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] < 0) {
        //         int temp = imin;
        //         imin = imax;
        //         imax = temp;
        //     }
        //     imax = Math.max(imax * nums[i], nums[i]);
        //     imin = Math.min(imin * nums[i], nums[i]);
        //     max = Math.max(max, imax);
        // }
        // return max;

        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        //考虑最小值为负数，乘以负数反而成了最大值的情况
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i-1] * nums[i], Math.max(dpMin[i-1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i-1] * nums[i], Math.min(dpMax[i-1] * nums[i], nums[i]));
        }

        Arrays.sort(dpMax);
        return dpMax[n-1];
    }
}
// @lc code=end

