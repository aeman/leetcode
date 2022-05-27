import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=732 lang=java
 *
 * [732] 我的日程安排表 III
 */

// @lc code=start
class MyCalendarThree {
    private TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
        this.events = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int duration : events.values()) {
            active += duration;
            ans = Math.max(ans, active);
        }

        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
// @lc code=end

