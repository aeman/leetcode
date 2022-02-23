import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        });

        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (envelopes[i][1] > envelopes[j][1]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }

        // Arrays.sort(dp);
        // return dp[n - 1];

        List<Integer> list = new ArrayList<Integer>();
        list.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = binarySearch(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid ;
            }
        }
        return low;
    }
}
// @lc code=end
