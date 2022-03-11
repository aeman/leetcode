import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2049 lang=java
 *
 * [2049] 统计最高分的节点数目
 */

// @lc code=start
class Solution {
    public int countHighestScoreNodes(int[] parents) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < parents.length; i++) {
            list.add(new ArrayList<Integer>());
        }

        long[] arr = new long[parents.length];
        for (int i = 1; i < parents.length; i++) {
            list.get(parents[i]).add(i);
        }

        dfs(list, arr, 0);

        long maxVal = Arrays.stream(arr).max().getAsLong();
        return (int) Arrays.stream(arr).filter(x -> x == maxVal).count();
    }

    private long dfs(List<List<Integer>> list, long[] arr, int i) {
        long prod = 1, sum = 1;
        for (int j : list.get(i)) {
            long count = dfs(list, arr, j);
            prod *= count;
            sum += count;
        }

        arr[i] = prod * (Math.max(1, list.size() - sum));
        return sum;
    }
}
// @lc code=end
