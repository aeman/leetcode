import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, n);
                    return;
                }
            }
        }

        Arrays.sort(nums);

        // if (nums == null || nums.length == 1) return;
        // int left = -1, right = -1;

        // for (int i = nums.length - 2; i >= 0; i--) {
        //     if (nums[i] < nums[i + 1]) {
        //         left = i;
        //         break;
        //     }
        // }

        // // 倒序数组，直接反转
        // if (left == -1) {
        //     reverse(nums, 0, nums.length - 1);
        //     return;
        // }

        // for (int i = nums.length - 1; i >= 0; i--) {
        //     if (nums[i] > nums[left]) {
        //         right = i;
        //         break;
        //     }
        // }
        // swap(nums, left, right);
        // reverse(nums, left + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

