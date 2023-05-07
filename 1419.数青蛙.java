/*
 * @lc app=leetcode.cn id=1419 lang=java
 *
 * [1419] 数青蛙
 */

// @lc code=start
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] counts = new int[5];
        int maxNum = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            switch(c) {
                case 'c': counts[0]++; break;
                case 'r': counts[1]++; break;
                case 'o': counts[2]++; break;
                case 'a': counts[3]++; break;
                case 'k': counts[4]++; break;
            }
            if(counts[0] < counts[1] || counts[1] < counts[2] || counts[2] < counts[3] || counts[3] < counts[4]) {
                return -1;
            }
            maxNum = Math.max(maxNum, counts[0] - counts[4]);
        }
        if(counts[0] != counts[1] || counts[0] != counts[2] || counts[0] != counts[3] || counts[0] != counts[4]) {
            return -1;
        }
        return maxNum;
    }
}
// @lc code=end

