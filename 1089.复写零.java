import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zero = (int) Arrays.stream(arr).filter(x -> x == 0).count();

        // 1.模拟
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 0) {
        //         for (int j = n - 1; j > i; j--) {
        //             arr[j] = arr[j - 1];
        //         }
        //         if (i + 1 < n)
        //             arr[i + 1] = 0;
        //         i++;
        //     }
        // }

        // 2.两次遍历
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 0) zero--;
            if (i + zero < n) {
                arr[i + zero] = arr[i];
                if (arr[i] == 0 && i + zero + 1 < n) {
                    arr[i + zero + 1] = 0;
                }
            }
        }
    }
}
// @lc code=end
