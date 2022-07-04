import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > minDiff) continue;

            if (diff < minDiff) {
                minDiff = diff;
                ans.clear();
            }

            List<Integer> list = new ArrayList<>();
            list.add(arr[i - 1]);
            list.add(arr[i]);
            ans.add(list);
        }

        return ans;
    }
}
// @lc code=end
