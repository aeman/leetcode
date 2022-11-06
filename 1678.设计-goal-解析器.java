import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=1678 lang=java
 *
 * [1678] 设计 Goal 解析器
 */

// @lc code=start
class Solution {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
// @lc code=end

