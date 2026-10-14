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
            ListNode temp = curr.next;
            curr.next = prev;       // The key to all of this!
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

/*
I realize now it's about rewiring where the curr.next node points, as opposed to needing to shuffle everything around within the ListNode structure.
*/
