import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);    // 每个孩子至少1颗糖果
        
        // 先从左到右遍历
        for (int i = 1; i < ans.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        // 再从右到左遍历
        for (int i = ans.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] +1);
            }
        }
        return Arrays.stream(ans).sum();
    }
}
// @lc code=end
