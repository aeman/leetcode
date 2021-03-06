import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=691 lang=java
 *
 * [691] 贴纸拼词
 */

// @lc code=start
class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int ans = dp(stickers, target, memo, (1 << n) - 1);
        return ans <= n ? ans : -1;
    }

    private int dp(String[] stickers, String target, int[] memo, int mask) {
        int n = target.length();
        if (memo[mask] < 0) {
            int res = n + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    res = Math.min(res, dp(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }
}
// @lc code=end
