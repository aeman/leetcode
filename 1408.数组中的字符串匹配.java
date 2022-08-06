import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
    public List<String> stringMatching(String[] words) {
        // Arrays.sort(words, (a, b) -> b.length() - a.length());

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].contains(words[i]) && i != j) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

