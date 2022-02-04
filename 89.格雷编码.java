import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                // 前面补1
                list.add(list.get(j) | (1 << (i - 1)));
            }
        }

        return list;
    }
}
// @lc code=end
