import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String sentence) {
        char[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (set.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
            }
            sb.append("ma");
            index++;
            for (int i = 1; i <= index; i++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
// @lc code=end

