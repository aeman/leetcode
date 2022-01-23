import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int count = matrix.length * matrix[0].length;

        //向left、down、right、up四个方向遍历，所有元素都遍历为循环条件
        while (count > 0) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
                count--;
            }
            up++;

            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                count--;
            }
            right--;

            if (down >= up) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                    count--;
                }
            }
            down--;

            if (right >= left) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                    count--;
                }
            }
            left++;
        }

        return list;
    }
}
// @lc code=end
