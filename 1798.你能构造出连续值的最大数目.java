import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1798 lang=java
 *
 * [1798] 你能构造出连续值的最大数目
 */

// @lc code=start
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        for (int coin : coins) {
            if (coin <= ans) {
                ans += coin;
            }
        }
        return ans;
    }
}
// @lc code=end

