import java.util.PriorityQueue;

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
        // ListNode ans = null;
        // for (int i = 0; i < lists.length; i++) {
        //     ans = mergeTwoList(ans, lists[i]);
        // }
        // return ans;
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val < o2.val ? -1 : 1);

        ListNode dummy = new ListNode(0), cur = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) queue.add(cur.next);
        }
        return dummy.next;
    }

    // public ListNode mergeTwoList(ListNode a, ListNode b) {
    //     if (a == null || b == null) {
    //         return a == null ? b : a;
    //     }
    //     ListNode head = new ListNode(0);
    //     ListNode tail = head, aPtr = a, bPtr = b;
    //     while (aPtr != null && bPtr != null) {
    //         if (aPtr.val <= bPtr.val) {
    //             tail.next = aPtr;
    //             aPtr = aPtr.next;
    //         } else {
    //             tail.next = bPtr;
    //             bPtr = bPtr.next;
    //         }
    //         tail = tail.next;
    //     }
    //     if (aPtr == null || bPtr == null) {
    //         tail.next = (aPtr == null ? b.next : a.next);
    //     }
    //     return head.next;
    // }
}
// @lc code=end

