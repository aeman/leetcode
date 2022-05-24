import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = piles[piles.length - 1];    // 最少吃一根，最多吃数量最多的那一堆

        while (low <= high) {
            int mid = (low + high) / 2, hours = 0;

            // 以中间速度吃，需要多少小时
            for (int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double) piles[i] / mid);
            }

            // 超时提高速度，太快降低速度
            if (hours > h)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}
// @lc code=end
