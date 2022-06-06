import javax.xml.parsers.FactoryConfigurationError;

/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill ==  5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                ten++;
                five--;
            } else {
                if (five == 0) return false;
                if (ten == 0 && five < 3) return false;
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
        }

        return true;
    }
}
// @lc code=end

