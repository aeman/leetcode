/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] flag = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i] |= 1 << (c - 'a');  // 用位记录该字符是否存在
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((flag[i] & flag[j]) == 0) { // 这两个单词没有重复的char
                    int prod = words[i].length() * words[j].length();
                    ans = Math.max(ans, prod);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

