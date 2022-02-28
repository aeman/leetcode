/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = head.next, sorted = head;

        while (cur != null) {
            if (sorted.val <= cur.val) {
                sorted = sorted.next;
            } else {
                ListNode temp = dummy;
                //找到插入节点的位置
                while (temp != null && temp.next.val < cur.val) {
                    temp = temp.next;
                }
                sorted.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
            }
            cur = sorted.next;
        }

        return dummy.next;
    }
}
// @lc code=end

