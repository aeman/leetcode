import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt(), high = Arrays.stream(weights).sum();

        while (low < high) {
            int mid = (low + high) / 2, totalDay = 1, sumWeight = 0;

            for (int i = 0; i < weights.length; i++) {
                if (sumWeight + weights[i] > mid) {
                    totalDay++;
                    sumWeight = 0;
                }
                sumWeight += weights[i];
            }

            if (totalDay > days)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
// @lc code=end
