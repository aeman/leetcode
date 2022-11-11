import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1704 lang=java
 *
 * [1704] 判断字符串的两半是否相似
 */

// @lc code=start
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = s.length(), left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(Character.toLowerCase(s.charAt(i)))) {
                if (i < n / 2) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        return left == right;
    }
}
// @lc code=end

