/*
 * @lc app=leetcode.cn id=1253 lang=java
 *
 * [1253] 重构 2 行二进制矩阵
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param upper
     * @param lower
     * @param colsum
     * @return
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = colsum[i];
            if (sum == 0) {
                a.add(0);
                b.add(0);
            } else if (sum == 2) {
                a.add(1);
                b.add(1);
                upper--;
                lower--;
            } else {
                if (upper >= lower) {
                    a.add(1);
                    b.add(0);
                    upper--;
                } else {
                    a.add(0);
                    b.add(1);
                    lower--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        if (upper == 0 && lower ==0) {
            ans.add(a);
            ans.add(b);
        }
        return ans;
    }
}
// @lc code=end

