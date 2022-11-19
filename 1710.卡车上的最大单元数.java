import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1710 lang=java
 *
 * [1710] 卡车上的最大单元数
 */

// @lc code=start
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;

        for (int[] type : boxTypes) {
            if (truckSize - type[0] >= 0) {
                truckSize -= type[0];
                ans += type[0] * type[1];
            } else {
                ans += truckSize * type[1];
                break;
            }
        }

        return ans;
    }
}
// @lc code=end
