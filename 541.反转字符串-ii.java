/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();

        for (int i = 0; i < n; i = i + 2 * k) {
            int j = i + k - 1;
            reverse(cs, i, Math.min(j, n - 1));
        }

        return String.valueOf(cs);
    }

    private void reverse(char[] cs, int left, int right) {
        while (left < right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end
