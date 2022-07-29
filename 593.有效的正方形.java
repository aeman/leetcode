import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(dist(p1, p2));
        set.add(dist(p1, p3));
        set.add(dist(p1, p4));
        set.add(dist(p2, p3));
        set.add(dist(p2, p4));
        set.add(dist(p3, p4));
        if (set.size() != 2 || set.contains(0)) return false;

        Integer[] arr = set.toArray(new Integer[2]);
        if (arr[0] > arr[1]) {
            return arr[0] == arr[1] * 2;
        } else {
            return arr[1] == arr[0] * 2;
        }
    }

    private Integer dist(int[] p1, int[] p2) {
        int edge1 = p1[0] - p2[0];
        int edge2 = p1[1] - p2[1];
        return edge1 * edge1 + edge2 * edge2;
    }
}
// @lc code=end

