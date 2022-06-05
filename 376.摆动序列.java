/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        
        // 1.dp
        // int[] up = new int[n], down = new int[n];
        // up[0] = down[0] = 1;

        // for (int i = 1; i < n; i++) {
        //     if (nums[i] > nums[i - 1]) {
        //         up[i] = Math.max(up[i - 1], down[i - 1] + 1);
        //         down[i] = down[i - 1];
        //     } else if (nums[i] < nums[i - 1]) {
        //         up[i] = up[i - 1];
        //         down[i] = Math.max(down[i - 1], up[i - 1] + 1);
        //     } else {
        //         up[i] = up[i - 1];
        //         down[i] = down[i - 1];
        //     }
        // }

        // return Math.max(up[n - 1], down[n - 1]);

        // 2.greedy
        int preDiff = nums[1] - nums[0];
        int ans = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff < 0 && preDiff >= 0) || (diff > 0 && preDiff <= 0)) {
                ans++;
                preDiff = diff;
            }
        }
        return ans;
    }
}
// @lc code=end
