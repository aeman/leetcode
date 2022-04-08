import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int longSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curSeq = 1, curNum = nums[i];
                while (set.contains(curNum + 1)) {
                    curSeq++;
                    curNum++;
                }
                longSeq = Math.max(longSeq, curSeq);
            }
        }

        return longSeq;
    }
}
// @lc code=end

