import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1630 lang=java
 *
 * [1630] 等差子数组
 */

// @lc code=start
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int left = l[i], right = r[i];
            int[] subNums = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(subNums);
            if (subNums.length <= 1) {
                res.add(true);
                continue;
            }
            int diff = subNums[1] - subNums[0];
            for (int j = 1; j < subNums.length; j++) {
                if (subNums[j] - subNums[j - 1] != diff) {
                    res.add(false);
                    break;
                }
                if (j == subNums.length - 1) {
                    res.add(true);
                }
            }
        }
        return res;
    }
}
// @lc code=end
