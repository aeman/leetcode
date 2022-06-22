/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        // 模拟单调栈栈结构
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num[c - 'a'] -= 1;
            if (visited[c - 'a']) continue;     // 栈中已有该字母，跳过
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {    //后面还有该字母，弹栈
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    break;
                }
            }
            visited[c - 'a'] = true;
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end
