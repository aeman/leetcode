/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // String s = Integer.toBinaryString(n);

        int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '1') count++;
        // }
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

