/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length, max = num;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                swap(arr, i, j);
                max = Math.max(max, Integer.parseInt(new String(arr)));
                swap(arr, i, j);
            }
        }

        return max;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
// @lc code=end

