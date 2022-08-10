/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // 1.模拟
        // StringBuilder sb = new StringBuilder();
        // int count = 1;
        // char cur = chars[0];
        // for (int i = 1; i < chars.length; i++) {
        //     char c = chars[i];
        //     if (c == cur) {
        //         count++;
        //     } else {
        //         sb.append(cur);
        //         if (count > 1) sb.append(count);
        //         cur = c;
        //         count = 1;
        //     }
        // }
        
        // sb.append(cur);
        // if (count > 1) sb.append(count);
        // for (int i = 0; i < sb.length(); i++) {
        //     chars[i] = sb.charAt(i);
        // }
        // return sb.length();

        // 2.双指针
        int left = 0, right = 0, n = chars.length;
        while (right < n) {
            char cur = chars[right];
            int cnt = 0;
            while (right < n && chars[right] == cur) {
                cnt++;
                right++;
            }
            chars[left++] = cur;
            if (cnt > 1) {
                for (char c : (cnt + "").toCharArray()) {
                    chars[left++] = c;
                }
            }
        }
        return left;
    }
}
// @lc code=end

