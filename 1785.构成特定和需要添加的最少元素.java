import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1785 lang=java
 *
 * [1785] 构成特定和需要添加的最少元素
 */

// @lc code=start
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0; // Arrays.stream(nums).mapToLong(x -> x).sum();
        for (int i : nums) {
            sum += i;
        }
        long diff = Math.abs(sum - goal);
        
        return (int) ((diff + limit - 1) / limit);
    }
}
// @lc code=end

