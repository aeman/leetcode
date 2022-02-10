import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] sums = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]] += nums[i];
        }

        return rob(sums);

        // if (nums.length == 0)
        // return 0;
        // int[] values = new int[10001];
        // for (int num : nums)
        // values[num] += num;

        // int prev1 = 0;
        // int prev2 = 0;

        // for (int value : values) {
        // int tmp = prev1;
        // prev1 = Math.max(prev2 + value, prev1);
        // prev2 = tmp;
        // }
        // return prev1;
    }

    private int rob(int[] sums) {
        int n = sums.length;
        int[] dp = new int[n];
        dp[0] = sums[0];
        dp[1] = Math.max(sums[0], sums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
// @lc code=end
