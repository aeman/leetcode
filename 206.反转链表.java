import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

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
        // 1.迭代
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

        // 2.队列
        // Deque<ListNode> queue  = new ArrayDeque<>();
        // while (head != null) {
        //     queue.offer(head);
        //     head = head.next;
        // }
        // ListNode dummy = new ListNode(), newHead = dummy;
        // while (!queue.isEmpty()) {
        //     ListNode node = queue.pollLast();
        //     node.next = null;
        //     newHead.next = node;
        //     newHead = newHead.next;
        // }
        // return dummy.next;

        // 3.递归
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

