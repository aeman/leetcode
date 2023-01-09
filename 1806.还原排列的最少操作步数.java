import java.util.Arrays;

import javafx.util.converter.PercentageStringConverter;

/*
 * @lc app=leetcode.cn id=1806 lang=java
 *
 * [1806] 还原排列的最少操作步数
 */

// @lc code=start
class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n], target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }

        int ans = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            ans++;
            if (Arrays.equals(perm, target)) {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

