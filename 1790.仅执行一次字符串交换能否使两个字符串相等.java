import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1790 lang=java
 *
 * [1790] 仅执行一次字符串交换能否使两个字符串相等
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) return false;
                diff.add(i);
            }
        }
        if (diff.size() == 0) return true;
        if (diff.size() != 2) return false;
        return (s1.charAt(diff.get(0)) == s2.charAt(diff.get(1))) && (s1.charAt(diff.get(1)) == s2.charAt(diff.get(0)));
    }
}
// @lc code=end

