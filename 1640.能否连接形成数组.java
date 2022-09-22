import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1640 lang=java
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        for (int i = 0; i < arr.length; ) {
            int idx = map.getOrDefault(arr[i], -1);
            if (idx == -1) return false;

            int[] t = pieces[idx];
            for (int j = 0; j < t.length; j++, i++) {
                if (arr[i] != t[j]) return false;
            }
        }

        return true;
    }
}
// @lc code=end

