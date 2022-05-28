/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length], counts = new int[1000 + 1];
        for (int num : arr1) counts[num]++;

        int index = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                ans[index++] = num;
                counts[num]--;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            while  (counts[i] > 0) {
                ans[index++] = i;
                counts[i]--;
            }
        }

        return ans;
    }
}
// @lc code=end

