/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] 总持续时间可被 60 整除的歌曲
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int ans = 0;
        for (int i : time) {
            if (i % 60 == 0) {
                ans += count[0];
            } else {
                ans += count[60 - i % 60];
            }
            count[i % 60]++;
        }
        return ans;
    }
}
// @lc code=end

