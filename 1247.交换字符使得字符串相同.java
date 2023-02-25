/*
 * @lc app=leetcode.cn id=1247 lang=java
 *
 * [1247] 交换字符使得字符串相同
 */

// @lc code=start
class Solution {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int xy = 0, yx = 0;
        // 统计 s1 和 s2 中 xy 和 yx 的个数
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        // 如果 xy 和 yx 的个数之和不为偶数，无法通过交换得到相同的字符串
        if ((xy + yx) % 2 != 0) {
            return -1;
        }
        // 如果 xy 和 yx 的个数都为奇数，需要进行一次额外的交换
        if (xy % 2 != 0 && yx % 2 != 0) {
            return xy / 2 + yx / 2 + 2;
        }
        // 如果 xy 和 yx 的个数都为偶数，只需要交换即可
        return xy / 2 + yx / 2;
    }
}
// @lc code=end

