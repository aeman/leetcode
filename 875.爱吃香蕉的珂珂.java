import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1_000_000_000;

        while (low <= high) {
            int mid = (low + high) / 2;
            int hour = 0;
            for (int i = 0; i < piles.length; i++) {
                hour += Math.ceil(1.0 * piles[i] / mid);
            }
            if (hour > h)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;

    }
}
// @lc code=end
