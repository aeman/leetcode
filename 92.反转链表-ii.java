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
        ListNode dummy = new ListNode(0, head), pre = dummy;

        //找到反转的起始位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next, temp = cur.next;

        for (int i = 0; i < right - left; i++) {
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end

