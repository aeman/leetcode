/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int black = 0, max = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'B') black++;
        }
        max = black;
        for (int i = k; i < arr.length; i++) {
            if (arr[i] == 'B') black++;
            if (arr[i - k] == 'B') black--;
            max = Math.max(black, max);
        }
        return k - max;
    }
}
// @lc code=end

