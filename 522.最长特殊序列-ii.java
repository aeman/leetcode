/*
 * @lc app=leetcode.cn id=522 lang=java
 *
 * [522] 最长特殊序列 II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; i++) {
            boolean checked = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSub(strs[i], strs[j])) {
                    checked = false;
                    break;
                }
            }
            if (checked) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean isSub(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == s.length();
    }
}
// @lc code=end
