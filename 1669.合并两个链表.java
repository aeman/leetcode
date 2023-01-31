/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1), cur = dummy, preA = dummy, postB = dummy;

        for (int i = 0; i < a; i++) {
            preA = preA.next;
            postB = postB.next;
        }

        for (int i = 0; i <= (b - a + 1); i++) {
            postB = postB.next;
        }

        cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        preA.next = list2;
        cur.next = postB;

        return dummy.next;
    }
}
// @lc code=end

