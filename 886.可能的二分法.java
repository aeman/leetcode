import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {
    private int[] parent;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        parent = new int[n];

        List<Integer>[] dis = new List[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            dis[i] = new ArrayList<>();
        }

        for (int[] d : dislikes) {
            int a = d[0] - 1, b = d[1] - 1;
            dis[a].add(b);
            dis[b].add(a);
        }

        for (int i = 0; i < n; ++i) {
            for (int j : dis[i]) {
                if (find(i) == find(j)) {
                    return false;
                }
                parent[find(j)] = find(dis[i].get(0));
            }
        }
        
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
// @lc code=end

