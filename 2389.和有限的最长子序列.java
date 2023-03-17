import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int left = 0;
            int maxLength = 0;
            int sum = 0;

            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while (sum > query) {
                    sum -= nums[left];
                    left++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
            }
            ans[i] = maxLength;
        }
        return ans;
    }
}
// @lc code=end
