/*
 * @lc app=leetcode.cn id=1753 lang=java
 *
 * [1753] 移除石子的最大得分
 */

// @lc code=start
class Solution {
    public int maximumScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c)), sum = a + b + c;
        return Math.min(sum - max, sum / 2);
    }
}
// @lc code=end
