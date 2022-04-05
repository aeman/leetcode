import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1 hash
        // ListNode pos = head;
        // Set<ListNode> set = new HashSet<>();
        // while (pos != null) {
        //     if (set.contains(pos)) {
        //         return pos;
        //     } else {
        //         set.add(pos);
        //     }
        //     pos = pos.next;
        // }
        // return null;
        
        // 2 point
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                break;
            }
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
// @lc code=end

