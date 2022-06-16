/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] % 2 != i % 2) {
        //         for (int j = i + 1; j < nums.length; j++) {
        //             if ((nums[j] % 2 != j % 2) && (nums[i] % 2 != nums[j] % 2)) {
        //                 swap(nums, i, j);
        //                 break;
        //             }
        //         }
        //     }
        // }

        int j = 1;  // i为偶数指针，j为奇数指针
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {  //如果i指向奇数，移动j找到下一个偶数交换
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
