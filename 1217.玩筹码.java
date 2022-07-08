/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) even++;
        }
        return Math.min(even, position.length - even);
    }
}
// @lc code=end

