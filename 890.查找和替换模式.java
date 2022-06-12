import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=890 lang=java
 *
 * [890] 查找和替换模式
 */

// @lc code=start
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else {
                if (map.get(x) != y) return false;
            }
        }
        return true;
    }
}
// @lc code=end

