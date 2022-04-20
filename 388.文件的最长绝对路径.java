/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];    //从1开始，第0层就是0

        int maxLen = 0;
        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 2; // 最后一个/t+2的位置正好就是当前层数
            int curLen = path.length() - (level - 1);   // 计算当前这一行的长度
            if (path.contains(".")) {
                maxLen = Math.max(maxLen, stack[level - 1] + curLen);
            } else {
                stack[level] = stack[level - 1] + curLen + 1;
            }
        }
        return maxLen;
    }
}
// @lc code=end

