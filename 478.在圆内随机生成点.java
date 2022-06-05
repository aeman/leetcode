import java.util.Random;

/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {
    private double xc, yc, radius;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.random = new Random();
        this.radius = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * radius) - radius;
            double y = random.nextDouble() * (2 * radius) - radius;
            if (x * x + y * y <= radius * radius) {
                return new double[] { xc + x, yc + y };
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end
