import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=753 lang=java
 *
 * [753] 破解保险箱
 */

// @lc code=start
class Solution {
    private Set<Integer> visited = new HashSet<>();
    private StringBuilder ans = new StringBuilder();
    private int highest, k;
    
    public String crackSafe(int n, int k) {
        this.k = k;
        this.highest = (int) Math.pow(10, n - 1);
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    private void dfs(int node) {
        for (int i = 0; i < k; i++) {
            int x = node * 10 + i;
            if (!visited.contains(x)) {
                visited.add(x);
                dfs(x % highest);
                ans.append(i);
            }
        }
    }
}
// @lc code=end

