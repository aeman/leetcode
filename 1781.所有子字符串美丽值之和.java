/*
 * @lc app=leetcode.cn id=1781 lang=java
 *
 * [1781] 所有子字符串美丽值之和
 */

// @lc code=start
class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}
// @lc code=end

