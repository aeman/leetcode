import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    
    public String minWindow(String s, String t) {
        // 保存目标串到map
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        
        int len = Integer.MAX_VALUE, minLeft = -1, minRight = -1;
        int left = 0, right = -1;

        while (right < s.length()) {
            right++;
            if (right < s.length() && ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    minLeft = left;
                    minRight = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minRight);
    }

    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry<Character, Integer> entry = iter.next(); 
            Character key = entry.getKey(); 
            Integer val = entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}
// @lc code=end

