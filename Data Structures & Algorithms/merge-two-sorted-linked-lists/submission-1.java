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

 /*
 Merge Two Sorted Linked Lists

 Create new array for linked lists to merge into.
 Likely to employ a while loop, checking to see if values are still present within either linked lists. If so, continue to compare the index value in one linked list against the other linked list's indexed value.

 Once completed, returned the head of the new sorted linked list.

 Simply said:
Merge two linked lists into a sorted linked list by means of comparison statements and a moving counter to sequentially proceed between both linked lists. The lesser of the two values gets added initially, then the respective lists counter increments by one, until end of list is reached.

CALLED IN HELP (looked at solution after 15 mins.):
- Create a dummy node and a node pointer pointing to it.
- While both lists have nodes (effectively what I was thinking about having values unaccounted for):
    + compare list1.val and list2.val
    + attach smaller node to node.next
    + move forward in chosen list
    + move node to node.next
- When one list becomes empty
    + attach remaining nodes to the other list to node.next
- Return dummy.next, which is the head of the merged list

 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return dummy.next;
    }
}