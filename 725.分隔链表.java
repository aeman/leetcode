/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];

        //计算链表长度
        int length = 0;
        ListNode temp = root;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int div = length / k, remain = length % k;
        
        for (int i = 0; i < k && root != null; i++) {
            parts[i] = root;
            int size = div + (remain > i ? 1 : 0);
            for (int j = 1; j < size; j++) {
                root = root.next;
            }
            temp = root.next;
            root.next = null;
            root = temp;
        }

        return parts;
    }
}
// @lc code=end

