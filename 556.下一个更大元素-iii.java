import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, len);
                    long ans = Long.valueOf(new String(nums));
                    return ans > Integer.MAX_VALUE ? -1 : (int) ans;
                }
            }
        }

        return -1;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

