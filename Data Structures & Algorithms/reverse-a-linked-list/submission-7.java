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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode temp = curr.next;  // offload next value
            curr.next = prev;   // reposition pointer
            prev = curr;    // reassign prev with current position
            curr = temp;    // move current position to next value
        }
        return prev;
}
}

// working through it alone.
