import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2341 lang=java
 *
 * [2341] 数组能形成多少数对
 */

// @lc code=start
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                ans[0]++;
            } else {
                set.add(num);
            }
        }
        ans[1] = set.size();
        return ans;
    }
}
// @lc code=end

