import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1624 lang=java
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, i);
            } else {
                ans = Math.max(ans, i - map.get(c) - 1);
            }

        }
        return ans;
    }
}
// @lc code=end
