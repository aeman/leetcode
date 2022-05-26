import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=699 lang=java
 *
 * [699] 掉落的方块
 */

// @lc code=start
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>(); // 记录左右高三个数字

        int maxHeight = 0;
        for (int i = 0; i < positions.length; i++) {
            int height = 0;
            for (int j = 0; j < list.size(); j++) {
                int[] block = list.get(j);
                if (block[1] <= positions[i][0] || block[0] >= positions[i][0] + positions[i][1])
                    continue;   // 和其他方块无碰撞
                height = Math.max(height, block[2]);
            }
            height += positions[i][1];
            maxHeight = Math.max(maxHeight, height);
            list.add(new int[] { positions[i][0], positions[i][0] + positions[i][1], height });
            ans.add(maxHeight);
        }
        return ans;
    }
}
// @lc code=end
