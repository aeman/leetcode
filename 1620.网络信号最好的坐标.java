/*
 * @lc app=leetcode.cn id=1620 lang=java
 *
 * [1620] 网络信号最好的坐标
 */

// @lc code=start
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxSignal = -1, ans[] = new int[0];
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int singal = sumOfSignal(new int[] { i, j }, towers, radius);
                if (singal > maxSignal) {
                    ans = new int[] { i, j };
                    maxSignal = singal;
                }
            }
        }
        return ans;
    }

    private int sumOfSignal(int[] pos, int[][] towers, int radius) {
        int ret = 0;
        for (int i = 0; i < towers.length; i++) {
            double d = distance(pos, towers[i]);
            if (d <= radius) {
                ret += towers[i][2] / (1 + d);
            }
        }
        return ret;
    }

    private double distance(int[] a, int[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }
}
// @lc code=end
