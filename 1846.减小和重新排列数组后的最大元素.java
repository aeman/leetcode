import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1846 lang=java
 *
 * [1846] 减小和重新排列数组后的最大元素
 */

// @lc code=start
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        
        return arr[arr.length - 1];
    }
}
// @lc code=end

