import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    private int minStep = Integer.MAX_VALUE;
    private Set<String> set = new HashSet<>();  // 保存每一步的变化
    
    public int minMutation(String start, String end, String[] bank) {
        backtrack(start, end, bank, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void backtrack(String start, String end, String[] bank, int steps) {
        if (start.equals(end)) {
            minStep = Math.min(minStep, steps);
            return;
        }

        for (String str : bank) {
            if (set.contains(str)) continue;    // 剪枝

            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (start.charAt(i) != str.charAt(i)) {
                    diff++;
                }
            }
            if (diff > 1) continue;     // 大于1个字符不同，不符合变化条件

            set.add(str);
            steps++;
            backtrack(str, end, bank, steps);
            steps--;
            set.remove(str);
        }
    }
}
// @lc code=end

