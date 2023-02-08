import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (!dp[n]) {
            return res;
        }
        dfs(s, wordSet, n, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, Set<String> wordSet, int end, List<String> cur, List<String> res) {
        if (end == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = cur.size() - 1; i >= 0; i--) {
                sb.append(cur.get(i));
                if (i > 0) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < end; i++) {
            String sub = s.substring(i, end);
            if (wordSet.contains(sub)) {
                cur.add(sub);
                dfs(s, wordSet, i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
// @lc code=end

