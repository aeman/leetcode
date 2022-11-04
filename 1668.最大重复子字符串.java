import javax.swing.BorderFactory;

/*
 * @lc app=leetcode.cn id=1668 lang=java
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        String temp = word;
        while (true) {
            if (sequence.contains(temp)) {
                ans++;
                temp += word;
            } else {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

