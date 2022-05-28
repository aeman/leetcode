/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // 利用快慢指针寻找中间节点，分割链表为2部分
        ListNode mid = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;

        // 第2段链表的头节点是slow
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        // 合并排序后的2部分链表
        return merge(node1, node2);
    }

    ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0), cur = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        if (node1 != null) cur.next = node1;
        if (node2 != null) cur.next = node2;

        return dummy.next;
    }
}
// @lc code=end

