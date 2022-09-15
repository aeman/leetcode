import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=672 lang=java
 *
 * [672] 灯泡开关 Ⅱ
 */

// @lc code=start
class Solution {
    public int flipLights(int n, int presses) {
        int[] buttons = new int[] {0b111111, 0b010101, 0b101010, 0b100100};
        
        Set<Integer> set = new HashSet<>();
        for (int mask = 0; mask < 1 << 4; mask++) {
            int count = Integer.bitCount(mask);
            if (count <= presses && count % 2 == presses % 2) {
                int status = 0;
                for (int i = 0; i < 4; i++) {
                    if (((mask >> i) & 1) == 1) status ^= buttons[i];
                }

                status &= ((1 << 6) - 1);
                status >>= (6 - Math.min(n, 6));
                set.add(status);
            }
        }
        return set.size();
    }
}
// @lc code=end

