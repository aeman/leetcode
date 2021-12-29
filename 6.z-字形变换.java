/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();

        //初始化每行
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int index = 0;
        while (index < c.length) {
            for (int i = 0; i < numRows && index < c.length; i++) {
                sb[i].append(c[index++]);
            }
            for (int i = numRows - 2; i >= 1 && index < c.length; i--) {
                sb[i].append(c[index++]);
            }
        }

        //把字符数组拼成一行输出
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}
// @lc code=end

