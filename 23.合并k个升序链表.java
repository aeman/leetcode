import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // 1.归并排序
        // return mergeLists(lists, 0, lists.length);

        // 2.小顶堆
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(e -> e.val));

        ListNode dummy = new ListNode(0), cur = dummy;
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;    // 必须截断，否则死循环
        return dummy.next;
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) return lists[start];
        
        int mid = (start + end) / 2;
        ListNode head1 = mergeLists(lists, start, mid);
        ListNode head2 = mergeLists(lists, mid, end);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1), cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2  = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
// @lc code=end

