/*
 * @lc app=leetcode.cn id=1769 lang=java
 *
 * [1769] 移动所有球到每个盒子所需的最小操作数
 */

// @lc code=start
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            char c = boxes.charAt(i);
            if (c == '1') {
                for (int j = 0; j < n; j++) {
                    ans[j] += Math.abs(i - j);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

