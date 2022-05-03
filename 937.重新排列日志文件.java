import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=937 lang=java
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] log1 = a.split(" ", 2);
            String[] log2 = b.split(" ", 2);

            boolean d1 = Character.isDigit(log1[1].charAt(0));
            boolean d2 = Character.isDigit(log2[1].charAt(0));

            if (!d1 && !d2) {
                int cmp = log1[1].compareTo(log2[1]);
                if (cmp != 0) return cmp;
                return log1[0].compareTo(log2[0]);
            }

            return d1 ? (d2 ? 0 : 1) : -1;
        });

        return logs;
    }
}
// @lc code=end

