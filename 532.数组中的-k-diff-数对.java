import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的 k-diff 数对
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) set.add(num - k);
            if (visited.contains(num + k)) set.add(num);
            visited.add(num);
        }
        return set.size();
    }
}
// @lc code=end

