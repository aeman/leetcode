/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //char[] array = s.toCharArray();
        // return (s + s).indexOf(s, 1) != s.length();
        int len = s.length();
        for (int i = len / 2; i >= 1; i--){
            if (len % i == 0) {
                int times = len / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) return true;
            }
        }

        return false;
    }
}
// @lc code=end

