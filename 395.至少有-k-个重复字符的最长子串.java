/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    private int dfs(String s, int left, int right, int k) {
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // 分治，寻找分割字符它的出现次数大于0且小于k
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return right - left + 1;
        }

        int i = left, ans = 0;
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i++;
            }
            if (i > right) {
                break;
            }
            int start = i;
            while (i <= right && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
// @lc code=end

