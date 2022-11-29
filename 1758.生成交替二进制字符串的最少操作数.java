/*
 * @lc app=leetcode.cn id=1758 lang=java
 *
 * [1758] 生成交替二进制字符串的最少操作数
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        int ans = 0;
        
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            int pre = arr[i - 1], cur = arr[i];
            if (pre == cur) {
                arr[i] = arr[i] == '0' ? '1' : '0';
                ans++;
            }
        }
        
        return Math.min(ans, s.length() - ans);
    }
}
// @lc code=end

