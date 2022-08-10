/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alien = new int[26];
        // 构造外星字母序的哈希表
        for (int i = 0; i < order.length(); i++) {
            alien[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                int pre = alien[words[i - 1].charAt(j) - 'a'];
                int cur = alien[words[i].charAt(j) - 'a'];
                if (pre < cur) {    // 当前组满足条件，比较下一组
                    break;
                } else if (pre > cur) {     // 不满足条件，直接退出
                    return false;
                }
            }

            // words = ["apple","app"]
            if (words[i - 1].length() > words[i].length() && words[i - 1].indexOf(words[i]) != -1)
                return false;
        }

        return true;
    }
}
// @lc code=end
