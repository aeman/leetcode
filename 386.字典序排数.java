import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(list, n, 0);
        return list;
    }

    private void dfs(List<Integer> list, int n, int num) {
        for (int i = 0; i <= 9; i++) {
            int cur = 10 * num + i;
            if (cur == 0)
                continue;
            if (cur > n)
                return;
            list.add(cur);
            dfs(list, n, cur);
        }
    }
}
// @lc code=end
