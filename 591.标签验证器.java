import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=591 lang=java
 *
 * [591] 标签验证器
 */

// @lc code=start
class Solution {
    public boolean isValid(String code) {
        Deque stack = new ArrayDeque<>();
        int n = code.length(), i = 0;

        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) return false;
                int j = -1; // 标签结束的位置
                if (code.charAt(i + 1) == '/') {  // 关闭标签
                    j = code.indexOf('>', i);
                    if (j < 0) return false;
                    String tag = code.substring(i + 2, j);
                    if (stack.isEmpty() || !stack.peek().equals(tag)) return false;
                    stack.pop();
                    if (stack.isEmpty() && j + 1 != n) return false;
                } else if (code.charAt(i + 1) == '!') {   // cdata
                    if (stack.isEmpty()) return false;
                    if (i + 9 > n) return false;
                    String cdata = code.substring(i + 2, i + 9);
                    if (!cdata.equals("[CDATA[")) return false;
                    j = code.indexOf("]]>", i);
                    if (j < 0) return false;
                } else {    // 起始便签
                    j = code.indexOf('>', i);
                    if (j < 0) return false;
                    String tag = code.substring(i + 1, j);
                    if (tag.length() < 1 || tag.length() > 9) return false;
                    for (int k = 0; k < tag.length(); k++) {
                        if (!Character.isUpperCase(tag.charAt(k))) return false;
                    }
                    stack.push(tag);
                }
                i = j + 1;
            } else {
                if (stack.isEmpty()) return false;
                i++;
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

