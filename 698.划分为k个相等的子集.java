/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int target = sum / k;
        if (sum % k != 0) return false;

        int[] buckets = new int[k];
        return backtrack(nums, 0, target, buckets);
    }

    private boolean backtrack(int[] nums, int index, int target, int[] buckets) {
        if (index == nums.length) {
            for (int b : buckets) {
                if (b != target) return false;
            }
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (nums[index] + buckets[i] > target) continue;

            buckets[i] += nums[index];
            if (backtrack(nums, index + 1, target, buckets)) return true;
            buckets[i] -= nums[index];
        }
        return false;
    }
}
// @lc code=end

