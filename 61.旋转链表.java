/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int lenth = 0;
        ListNode fast = head, slow = head, count = head;
        while (count != null) {
            lenth++;
            count = count.next;
        }
        if (lenth == k || k % lenth == 0) return head;
        int step = k % lenth;
        for (int i = 0; i < step; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            if (fast.next == null) {
                count = slow.next;
                break;
            } else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        fast.next = head;
        slow.next = null;

        return count;
    }
}
// @lc code=end

