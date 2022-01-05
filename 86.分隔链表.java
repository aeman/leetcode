/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0), gt = new ListNode(0);
        ListNode ltHead = lt, gtHead = gt;
        
        while (head != null) {
            if (head.val < x) {
                lt.next = head;
                lt = head;
            } else {
                gt.next = head;
                gt = head;
            }
            head = head.next;
        }

        lt.next = gtHead.next;
        gt.next = null;
        return ltHead.next;
    }
}
// @lc code=end

