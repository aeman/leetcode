import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1813 lang=java
 *
 * [1813] 句子相似性 III
 */

// @lc code=start
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int m = words1.length, n = words2.length;
        int left = 0, right = 0;
        while (left < m && left < n && words1[left].equals(words2[left])) {
            left++;
        }
        while (right < m - left && right < n - left && words1[m - right - 1].equals(words2[n - right - 1])) {
            right++;
        }
        return left + right == Math.min(m, n);
    }
}
// @lc code=end

