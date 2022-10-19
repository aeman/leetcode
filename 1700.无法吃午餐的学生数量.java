import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1700 lang=java
 *
 * [1700] 无法吃午餐的学生数量
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int s1 = Arrays.stream(students).sum(), s0 = n - s1;

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }

        return s0 + s1;
    }
}
// @lc code=end
