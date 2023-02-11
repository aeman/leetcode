import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2335 lang=java
 *
 * [2335] 装满杯子需要的最短总时长
 */

// @lc code=start
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[0] + amount[1]) return amount[2];
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
// @lc code=end

