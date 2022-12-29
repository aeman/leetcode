import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2032 lang=java
 *
 * [2032] 至少在两个数组中出现的值
 */

// @lc code=start
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        fillMap(nums1, map);
        fillMap(nums2, map);
        fillMap(nums3, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private void fillMap(int[] nums, Map<Integer, Integer> map) {
        Arrays.sort(nums);
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
    }
}
// @lc code=end

