/*
 * @lc app=leetcode.cn id=2682 lang=java
 *
 * [2682] 找出转圈游戏输家
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        for (int i = k, j = 0; !visited[j]; i += k) {
            visited[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) list.add(i + 1);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
// @lc code=end

