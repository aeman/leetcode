import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2347 lang=java
 *
 * [2347] 最好的扑克手牌
 */

// @lc code=start
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (char c : suits) {
            set.add(c);
        }
        if (set.size() == 1) return "Flush";

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : ranks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() == 5) return "High Card";
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) return "Three of a Kind";
        }
        return "Pair";
    }
}
// @lc code=end

