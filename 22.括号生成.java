import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    private List<String> list = new ArrayList<>();
    private StringBuilder sub = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return list;
    }

    public void backtrack(int open, int close, int max) {
        if (sub.length() == max * 2) {
            list.add(sub.toString());
            return;
        }

        if (open < max) {
            sub.append("(");
            backtrack(open + 1, close, max);
            sub.deleteCharAt(sub.length() - 1);
        } 
        
        if (close < open) {
            sub.append(")");
            backtrack(open, close + 1, max);
            sub.deleteCharAt(sub.length() - 1);
        }
    }
}
// @lc code=end

