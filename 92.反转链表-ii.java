/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode vNode = new ListNode(0, head);
        ListNode pre = vNode;

        //找到反转的起始位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode begin = pre.next;
        ListNode second = begin.next;

        for (int i = 0; i < right - left; i++) {
            begin.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = begin.next;
        }

        return vNode.next;
    }
}
// @lc code=end

