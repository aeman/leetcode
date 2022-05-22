import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
class Solution {
    private Map<Integer, Boolean> map = new HashMap<>();
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        
        return dfs(maxChoosableInteger, desiredTotal, 0, 0);
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int num, int total) {
        if (!map.containsKey(num)) {
            boolean win = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((num >> i) & 1) == 0) {
                    if (i + 1 + total >= desiredTotal) {
                        win = true;
                        break;
                    }

                    if (!dfs(maxChoosableInteger, desiredTotal, num | (1 << i), total + i + 1)) {
                        win = true;
                        break;
                    }
                }
            }
            map.put(num, win);
        }
        return map.get(num);
    }
}
// @lc code=end

