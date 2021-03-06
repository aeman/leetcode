/*
 * @lc app=leetcode.cn id=798 lang=java
 *
 * [798] 得分最高的最小轮调
 */

// @lc code=start
class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];

        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high)
                diffs[0]++;
        }

        int index = 0, maxScore = 0, score = 0;
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                index = i;
                maxScore = score;
            }
        }

        return index;
    }
}
// @lc code=end
