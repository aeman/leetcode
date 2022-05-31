import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001], arr2 = new int[1001], arr3 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i]] = 1;
        }

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == 2)
                list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
