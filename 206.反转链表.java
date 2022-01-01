/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // ListNode pre = null;
        // ListNode cur = head;
        // ListNode temp;

        // while (cur != null) {
        //     temp = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = temp;
        // }
        // return pre;

        return recursiveNode(head, null);
    }

    public ListNode recursiveNode(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return recursiveNode(next, cur);
    }
}
// @lc code=end

