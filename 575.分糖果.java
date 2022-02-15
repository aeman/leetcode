import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int n = candyType.length;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (ans >= n / 2)
                break;
            if (candyType[i] != candyType[i - 1]) {
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end
