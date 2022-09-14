import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] 删除某些元素后的数组均值
 */

// @lc code=start
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, sum = 0;

        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += arr[i];
        }

        return sum / (n * 0.9);
    }
}
// @lc code=end

