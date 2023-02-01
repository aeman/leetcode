import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2325 lang=java
 *
 * [2325] 解密消息
 */

// @lc code=start
class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (set.add(c)) {
                map.put(c, (char) ('a' + set.size() - 1));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != ' ') {
                ans.append(map.get(c));
            } else {
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}
// @lc code=end

