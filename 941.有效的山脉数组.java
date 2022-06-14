/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;

        while (left < n - 1 && arr[left] < arr[left + 1])
            left++;
        while (right > 0 && arr[right] < arr[right - 1])
            right--;

        return left > 0 && right < n - 1 && left == right;
    }
}
// @lc code=end
