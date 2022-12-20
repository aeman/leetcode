import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1760 lang=java
 *
 * [1760] 袋子里最少数目的球
 */

// @lc code=start
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num - 1) / mid;
            }
            if (sum <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end
