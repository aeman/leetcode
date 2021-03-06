/*
 * @lc app=leetcode.cn id=2069 lang=java
 *
 * [2069] 模拟行走机器人 II
 */

// @lc code=start
class Robot {
    private String[] dirs = { "East", "North", "West", "South" };
    private int width, height, x, y, dir, perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = this.y = 0;
        this.dir = 0;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        // 只有一个点，原地转向
        if (num >= perimeter && num % perimeter == 0 && x == 0 && y == 0) dir = 3;

        num %= perimeter;   //如果步数大于周长，计算有效移动步数
        while (num > 0) {
            //四种特殊情况，先转向
            if ((x == width - 1 && dir == 0) || (y == height - 1 && dir == 1) 
                    || (x == 0 && dir == 2) || (y == 0 && dir == 3)) {
                dir = (dir + 1) % 4;
                continue;
            }
            if (dir == 0)
                x++;
            if (dir == 1)
                y++;
            if (dir == 2)
                x--;
            if (dir == 3)
                y--;
            num--;
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        return dirs[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
// @lc code=end
