/*
https://leetcode.com/problems/odd-even-linked-list/description/

traverse the list-> [a b c d] a.next = b.next, a to a.next -> [_ b a d] b.next = a.next, b to b.next -> [_ _ a b] -> connect end of odds to start of evens (head.next)

time: O(n) -> traverse the linked list a single time
space: O(1) -> pointers for odd/even and odd/even list heads
*/

class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = head.next;

        while (even != null && even.next != null) {
           odd.next = even.next;
           odd = odd.next;

           even.next = odd.next;
           even = even.next;
        }

        odd.next = even_head;
        
        return head;
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
