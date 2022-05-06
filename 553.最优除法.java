/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i + 1 < nums.length) sb.append("/");
        }
        //除了nums[1]作为分母，其他数字都作为分母的情况结果最大
        if (nums.length > 2) {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
// @lc code=end

