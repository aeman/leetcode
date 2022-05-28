import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();     // 异位词长度
        if (s.length() < n) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        int[] sArr = new int[26], pArr = new int[26];

        for (char c : p.toCharArray()) {
            pArr[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) list.add(0);

        for (int i = n; i < s.length(); i++) {
            sArr[s.charAt(i - p.length()) - 'a']--;
            sArr[s.charAt(i) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                list.add(i - n + 1);
            }
        }

        return list;
    }
}
// @lc code=end
