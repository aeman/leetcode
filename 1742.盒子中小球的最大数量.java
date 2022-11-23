import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1742 lang=java
 *
 * [1742] 盒子中小球的最大数量
 */

// @lc code=start
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0, x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            map.put(box, map.getOrDefault(box, 0) + 1);
            ans = Math.max(ans, map.get(box));
        }
        return ans;
    }
}
// @lc code=end
