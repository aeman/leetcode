import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]);
            if (nums[pos - 1] > 0) {
                nums[pos - 1] *= -1;
            } else {
                list.add(pos);
            }
        }

        return list;
    }
}
// @lc code=end

