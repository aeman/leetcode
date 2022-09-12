import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length, ans = 0;

        Arrays.sort(nums);
        if (nums[0] >= n) return n;

        for (int i = 1; i < n; i++) {
            ans = n - i;
            if (nums[i] >= ans && nums[i - 1] < ans) return ans;
        }
        return -1;
    }
}
// @lc code=end

