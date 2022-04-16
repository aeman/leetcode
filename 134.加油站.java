import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = Arrays.stream(gas).sum(), sumCost = Arrays.stream(cost).sum();
        // 总油量小于总油耗，一定无解
        if (sumGas < sumCost)
            return -1;

        // 轮询加油站，找到出发点
        int start = 0, car = 0;
        for (int i = 0; i < gas.length; i++) {
            car += gas[i] - cost[i];
            if (car < 0) {
                start = i + 1;
                car = 0;
            }
        }
        return start;
    }
}
// @lc code=end
