import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2367 lang=java
 *
 * [2367] 算术三元组的数目
 */

// @lc code=start
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num + diff)) ans++;
        }
        return ans;
    }
}
// @lc code=end

