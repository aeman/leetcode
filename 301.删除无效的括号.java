import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, ans, new char[]{'(', ')'});
        return ans;
    }

    private void backtrack(String s, int lastI, int lastJ, List<String> ans, char[] par) {
        for (int stack = 0, i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    backtrack(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, ans, par);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') { // finished left to right
            backtrack(reversed, 0, 0, ans, new char[]{')', '('});
        } else { // finished right to left
            ans.add(reversed);
        }
    }
}
// @lc code=end

