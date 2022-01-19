/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }
    }
}
// @lc code=end

