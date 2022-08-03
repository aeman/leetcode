import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=899 lang=java
 *
 * [899] 有序队列
 */

// @lc code=start
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String s2 = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(s2) < 0) s2 = sb.toString();
            }
            return s2;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
// @lc code=end

