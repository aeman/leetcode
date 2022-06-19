import java.util.List;  

/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {
    private int count;
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(0, rooms);

        return count == n;
    }

    private void dfs(int index, List<List<Integer>> rooms) {
        visited[index] = true;
        count++;

        for (Integer i : rooms.get(index)) {
            if (!visited[i]) dfs(i, rooms);
        }
    }
}
// @lc code=end

