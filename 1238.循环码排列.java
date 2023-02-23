import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1238 lang=java
 *
 * [1238] 循环码排列
 */

// @lc code=start
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        for (int i = 1; i <= n; i++) {
            int m = list.size();
            for (int j = m - 1; j >= 0; j--) {
                list.add(((list.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return list;
    }
}
// @lc code=end

