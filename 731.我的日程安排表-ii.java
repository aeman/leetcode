import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=731 lang=java
 *
 * [731] 我的日程安排表 II
 */

// @lc code=start
class MyCalendarTwo {
    private TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        this.events = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // 利用差分数组思想
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int duration : events.values()) {
            active += duration;
            if (active >= 3) {
                events.put(start, events.get(start) - 1);
                events.put(end, events.get(end) + 1);
                if (events.get(start) == 0) {
                    events.remove(start);
                }
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

