import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                ans = ans - value;
            } else {
                ans = ans + value;
            }
        }
        return ans;
    }
}
// @lc code=end
