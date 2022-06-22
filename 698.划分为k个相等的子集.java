import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        boolean[] used = new boolean[nums.length];
        // Arrays.sort(nums);

        if (sum % k != 0)
            return false;
        int target = sum / k;
        if (nums[nums.length - 1] > target)
            return false;
        return dfs(nums, nums.length - 1, target, 0, k, used);
    }

    public static boolean dfs(int[] nums, int begin, int target, int curSum, int k, boolean[] used) {
        // 剪枝1
        if (k == 1)
            return true;
        if (curSum == target)
            return dfs(nums, nums.length - 1, target, 0, k - 1, used);// 找到了一个组合,还有k-1个.
        // 剪枝4
        for (int i = begin; i >= 0; i--) {
            // 使用过的元素就不能再使用了
            if (used[i])
                continue;
            // // 剪枝2
            if (curSum + nums[i] > target)
                continue;
            used[i] = true;// 添加元素nums[i]
            if (dfs(nums, i - 1, target, curSum + nums[i], k, used))
                return true;// 如果添加这个元素后，完成了题目要求，就return true.
            used[i] = false;// 回溯
            while (i > 0 && nums[i - 1] == nums[i])// 剪枝3
                i--;
        }
        return false;
    }
}
// @lc code=end
