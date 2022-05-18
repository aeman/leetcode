import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1575 lang=java
 *
 * [1575] 统计所有可行路径
 */

// @lc code=start
class Solution {
    private int MOD = 1000000007;
    private int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        this.memo = new int[n][fuel + 1];
        // for (int i = 0; i < locations.length; i++) {    
        //     Arrays.fill(memo[i], -1);
        // }
        // return dfs(locations, start, finish, fuel);

        // 这里的memo[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        for (int i = 0; i <= fuel; i++) {
            memo[finish][i] = 1;
        }
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(locations[i] - locations[k]);
                        if (cur >= need) {
                            memo[i][cur] += memo[k][cur-need];
                            memo[i][cur] %= MOD;
                        }
                    }
                }
            }
        }
        return memo[start][fuel];
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        if (memo[start][fuel] != -1) return memo[start][fuel];

        // 如果一步到达不了，说明从位置 start 不能到达 finish 位置
        if (Math.abs(locations[start] - locations[finish]) > fuel) {
            memo[start][fuel] = 0;
            return 0;
        }

        // 计算油量为 fuel，从位置 start 到 finish 的路径数量，由于每个点都可以经过多次，如果 start = finish，那么本身就算一条路径
        int sum = start == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int need = Math.abs(locations[i] - locations[start]);
                if (fuel >=  need) {
                    sum += dfs(locations, i, finish, fuel - need);
                    sum %= MOD;
                }
            }
        }

        memo[start][fuel] = sum;
        return sum;
    }
}
// @lc code=end

