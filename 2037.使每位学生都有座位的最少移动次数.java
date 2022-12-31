import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2037 lang=java
 *
 * [2037] 使每位学生都有座位的最少移动次数
 */

// @lc code=start
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < students.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
// @lc code=end

