import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int[] path = new int[4];
        backtrack(s, 0, 0, path, list);
        return list;
    }

    private void backtrack(String s, int idx, int segment, int[] path, List<String> list) {
        if (segment == 4 && idx == s.length()) {
            list.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        } else if (segment == 4 || idx == s.length()) {
            return;
        }

        for (int i = 1; i <= 3 && (idx + i) <= s.length(); i++) {
            int val = Integer.parseInt(s.substring(idx, idx + i));
            if (val > 255 || i >= 2 && s.charAt(idx) == '0')
                break;

            path[segment] = val;
            backtrack(s, idx + i, segment + 1, path, list);
            // path[segment] = -1;
        }

    }
}
// @lc code=end
