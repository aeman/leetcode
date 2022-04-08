import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return i;
            set.add(i);
        }
        return -1;
    }
}
// @lc code=end

