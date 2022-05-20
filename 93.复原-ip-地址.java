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

        // ip段长度在1-3之间
        for (int len = 1; len <= 3 && (index + len) <= s.length(); len++) {
            int val = Integer.parseInt(s.substring(index, index + len));
            // ip段大于255或者以0开头，不符合规则退出
            if (val > 255 || (len >= 2 && s.charAt(index) == '0'))
                break;

            path[segment] = val;
            backtrack(s, index + len, segment + 1);
        }
    }
}
// @lc code=end
