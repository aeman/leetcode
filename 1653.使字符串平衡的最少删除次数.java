/*
 * @lc app=leetcode.cn id=1653 lang=java
 *
 * [1653] 使字符串平衡的最少删除次数
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {
        int countB = 0; // 统计字符 b 出现的次数
        int deletions = 0; // 记录删除的次数
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                // 当出现 s[i] = 'a' 且前面已经出现 s[j] = 'b' 时，需要删除 s[j]
                deletions = Math.min(deletions + 1, countB);
            } else { // c == 'b'
                countB++;
            }
        }
        return deletions;
    }
}
// @lc code=end

