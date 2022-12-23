/*
 * @lc app=leetcode.cn id=2011 lang=java
 *
 * [2011] 执行操作后的变量值
 */

// @lc code=start
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String op : operations) {
            if (op.equals("++X") || op.equals("X++")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
// @lc code=end

