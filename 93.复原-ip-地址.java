import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    private List<String> ans = new ArrayList<>();
    private int[] path = new int[4];

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    private void backtrack(String s, int index, int segment) {
        if (segment == 4) {
            if (index == s.length()) {
                ans.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            }
            return;
        }

        for (int i = 1; i <= 3 && (index + i) <= s.length(); i++) {
            int val = Integer.parseInt(s.substring(index, index + i));
            if (val > 255 || (i >= 2 && s.charAt(index) == '0'))
                break;

            path[segment] = val;
            backtrack(s, index + i, segment + 1);
            // path[segment] = -1;
        }

    }
}
// @lc code=end
