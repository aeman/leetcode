import java.util.List;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode[] left = new ListNode[1];
        left[0] = head;
        reorder(left, head);

        // ListNode mid = mid(head), midNext = mid.next;
        // mid.next = null;
        // ListNode p2 = reverse(midNext);

        // ListNode p1 = head, p1Next;
        // while (p1 != null && p2 != null) {
        //     p1Next = p1.next;
        //     p1.next = p2;
        //     p1 = p2;
        //     p2 = p1Next;
        // }
    }

    public ListNode mid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void reorder(ListNode left[], ListNode right) {
        if (right == null) return;
        reorder(left, right.next);

        if (left[0].next != null) {
            ListNode leftNext = left[0].next;
            left[0].next = right;
            right.next = leftNext;
            left[0] = leftNext;
        }

        if (left[0].next == right) {
            left[0].next = null;
        }
    }
}
// @lc code=end

