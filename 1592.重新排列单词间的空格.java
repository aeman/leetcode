/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        int word = 0, space = 0, midNum = 0, tailNum = 0;
        String[] split = text.trim().split("\\s+");
        word = split.length;
        for (char c : text.toCharArray()) {
            if (c == ' ') space++;
        }

        StringBuilder sb = new StringBuilder();
        if (split.length == 1) {
            sb.append(split[0]);
            for (int i = 0; i < space; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        midNum = space / (word - 1);
        tailNum = space % (word - 1);
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i]);
            for (int j = 0; j < midNum; j++) {
                sb.append(' ');
            }
        }
        sb.append(split[split.length - 1]);
        for (int j = 0; j < tailNum; j++) {
            sb.append(' ');
        }

        return sb.toString();
    }
}
// @lc code=end

