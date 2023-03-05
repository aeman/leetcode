/*
 * @lc app=leetcode.cn id=1599 lang=java
 *
 * [1599] 经营摩天轮的最大利润
 */

// @lc code=start
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0; // 等待上座舱的游客数量
        int rotations = 0; // 轮转次数
        int maxProfit = 0; // 最大利润
        int totalProfit = 0; // 当前总利润
        int i = 0; // 当前轮转次数

        while (i < customers.length || waiting > 0) {
            // 处理当前轮转的游客
            if (i < customers.length) {
                waiting += customers[i];
            }

            // 计算当前座舱的游客数量
            int boarded = Math.min(4, waiting);
            waiting -= boarded;

            // 计算当前轮转的利润
            int profit = boarded * boardingCost - runningCost;
            totalProfit += profit;

            // 更新最大利润和轮转次数
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                rotations = i + 1;
            }

            // 进行下一轮转
            i++;
        }

        return maxProfit > 0 ? rotations : -1;
    }
}
// @lc code=end

