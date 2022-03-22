/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(parent, s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(parent, s.charAt(0)- 'a') == find(parent, s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
// @lc code=end

