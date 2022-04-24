/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);

        int left = -1, right = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (left == -1) {
                    left = i;
                } else {
                    right = i;
                    ans = Math.max(ans, right - left);
                    left = right;
                }
            }
        }
        
        return ans;
    }
}
// @lc code=end

