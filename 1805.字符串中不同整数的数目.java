import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1805 lang=java
 *
 * [1805] 字符串中不同整数的数目
 */

// @lc code=start
class Solution {
    public int numDifferentIntegers(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                arr[i] = ' ';
            }
        }
        String temp = new String(arr);
        String[] ss = temp.split(" ");

        Set<String> set = new HashSet<>();
        for (String s : ss) {
            if (s.isEmpty()) continue;
            set.add(cutZero(s));
        }
        return set.size();
    }

    private String cutZero(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') break;
        }
        return s.substring(i);
    }
}
// @lc code=end

