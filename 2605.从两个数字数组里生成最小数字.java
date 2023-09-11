/*
 * @lc app=leetcode.cn id=2605 lang=java
 *
 * [2605] 从两个数字数组里生成最小数字
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                return nums2[i];
            }
        }

        int a = nums1[0], b = nums2[0];
        return Math.min(b * 10 + a, a * 10 + b);
    }
}
// @lc code=end

