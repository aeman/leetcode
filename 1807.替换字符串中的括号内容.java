import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1807 lang=java
 *
 * [1807] 替换字符串中的括号内容
 */

// @lc code=start
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder(), key = new StringBuilder();
        boolean addKey = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                addKey = false;
                if (map.containsKey(key.toString())) {
                    sb.append(map.get(key.toString()));
                } else {
                    sb.append('?');
                }
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

