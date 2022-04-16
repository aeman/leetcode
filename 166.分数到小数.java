import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a % b == 0) return String.valueOf(a / b);

        StringBuilder sb = new StringBuilder();
        if (a * b < 0) sb.append("-");

        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b).append(".");
        a %= b;

        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录a的位置
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int idx = map.get(a);
                return String.format("%s(%s)", sb.substring(0, idx), sb.substring(idx));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

