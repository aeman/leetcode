import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=630 lang=java
 *
 * [630] 课程表 III
 */

// @lc code=start
class Solution {
    public int scheduleCourse(int[][] courses) {
        // 按课程的结束时间排序
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0; // 队列中上课总时长
        for (int[] course : courses) {
            int duration = course[0], lastday = course[1];
            sum += duration;
            queue.offer(duration);
            if (sum > lastday)
                sum -= queue.poll();
        }

        return queue.size();
    }
}
// @lc code=end
