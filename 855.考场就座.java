import java.util.PriorityQueue;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=855 lang=java
 *
 * [855] 考场就座
 */

// @lc code=start
class ExamRoom {
    private int n;
    private TreeSet<Integer> seats;
    private PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<Integer>();
        this.pq = new PriorityQueue<int[]>((a, b) -> {
            int d1 = a[1] - a[0], d2 = b[1] - b[0];
            return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                int d = p[1] - p[0];
                if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                    break;
                }
                pq.poll();
                pq.offer(new int[] { p[0], p[0] + d / 2 });
                pq.offer(new int[] { p[0] + d / 2, p[1] });
                seats.add(p[0] + d / 2);
                return p[0] + d / 2;
            }
            pq.poll(); // leave 函数中延迟删除的区间在此时删除
        }
        if (right > left) { // 最右的位置更优
            pq.offer(new int[] { seats.last(), n - 1 });
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[] { 0, seats.first() });
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p), next = seats.higher(p);
            pq.offer(new int[] { prev, next });
        }
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
// @lc code=end
