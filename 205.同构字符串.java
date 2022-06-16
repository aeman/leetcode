import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i), t1 = t.charAt(i);
            if ((s2t.containsKey(s1) && s2t.get(s1) != t1) || (t2s.containsKey(t1) && t2s.get(t1) != s1))
                return false;
            s2t.put(s1, t1);
            t2s.put(t1, s1);
        }
        return true;
    }
}
// @lc code=end
