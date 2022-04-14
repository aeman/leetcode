import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
   
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            max = Math.max(max, sum);
        }

        return max;
    }
}
// @lc code=end

