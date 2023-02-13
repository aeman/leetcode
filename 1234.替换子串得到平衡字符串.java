/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'A']++;
        }

        int n = s.length() / 4, ans = s.length();
        if (check(cnt, n)) return 0;

        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, n)) {
                cnt[s.charAt(r) - 'A']--;
                r++;
            }
            if (!check(cnt, n)) {
                break;
            }
            ans = Math.min(ans, r - l);
            cnt[s.charAt(l) - 'A']++;
        }
        return ans;
    }

    private boolean check(int[] cnt, int n) {
        if (cnt['Q' - 'A'] > n || cnt['W' - 'A'] > n || cnt['E' - 'A'] > n || cnt['R' - 'A'] > n) {
            return false;
        }
        
        return true;
    }
}
// @lc code=end

