/*
https://leetcode.com/problems/middle-of-the-linked-list/description/

fast pointer travels 2 nodes/cycle, slow pointer travels 1 node/cycle -> when fast reaches last possible jump, slow will only be halfway -> return slow

time: O(n) -> read the list using fast
space: O(1) -> pointers to fast, slow node locations
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

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
 
