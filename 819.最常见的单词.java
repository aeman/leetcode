import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = Arrays.stream(banned).collect(Collectors.toSet());
        
        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = paragraph.charAt(i);
            if (!Character.isLetter(c)) {
                chars[i] = ' ';
                continue;   //非字符不处理大小写
            }
            chars[i] = Character.toLowerCase(c);
        }
        paragraph = new String(chars);

        int max = 0;
        String word = "";
        Map<String, Integer> map = new HashMap<>();
        String[] arr =  paragraph.split(" ");
        for (String s : arr) {
            if (!set.contains(s) && !s.isEmpty()) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (map.get(s) > max) {
                    max = map.get(s);
                    word = s;
                }
            }
        }

        return word;
    }
}
// @lc code=end

