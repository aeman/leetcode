/*
 * @lc app=leetcode.cn id=2287 lang=java
 *
 * [2287] 重排字符形成目标字符串
 */

// @lc code=start
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] targetArr = new int[26], sArr = new int[26];
        for (char c : target.toCharArray()) {
            targetArr[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (sArr[i] == 0 && targetArr[i] > 0) return 0;
            if (targetArr[i] > 0) {
                ans = Math.min(ans, sArr[i] / targetArr[i]);
            }
        }
        return ans;
    }
}
// @lc code=end

