import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private Random random = new Random();
    private Set<Integer> set = new HashSet<>();
    private int bound;
    
    public Solution(int n, int[] blacklist) {
        bound = n - blacklist.length;
        for (int black : blacklist) {
            if (black >= bound) set.add(black);
        }

        int index = bound;
        for (int black : blacklist) {
            if (black < bound) {
                while (set.contains(index)) index++; // 如果index本身在黑名单，移动一位
                map.put(black, index);  // 映射范围内的黑名单到范围外的白名单上
                index++;
            }
        }
    }
    
    public int pick() {
        int num = random.nextInt(bound);
        return map.getOrDefault(num, num);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

