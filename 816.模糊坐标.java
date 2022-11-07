import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=816 lang=java
 *
 * [816] 模糊坐标
 */

// @lc code=start
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        s = s.substring(1, s.length() - 1);

        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<String> left = getPos(s.substring(0, i));
            if (left.isEmpty())
                continue;
            List<String> right = getPos(s.substring(i));
            if (right.isEmpty())
                continue;
            for (String l : left) {
                for (String r : right) {
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }

        return ans;
    }

    private List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if (s.charAt(0) != '0' || s.equals("0"))
            pos.add(s);

        for (int i = 1; i < s.length(); i++) {
            if (i != 1 && s.charAt(0) == '0' || s.charAt(s.length() - 1) == '0')
                continue;
            pos.add(s.substring(0, i) + "." + s.substring(i));
        }
        return pos;
    }
}
// @lc code=end
