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

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted linked list and return the head of the new sorted linked list.

The new list should be made up of nodes from list1 and list2.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,5]

Output: [1,1,2,3,4,5]

Example 2:

Input: list1 = [], list2 = [1,2]

Output: [1,2]

Example 3:

Input: list1 = [], list2 = []

Output: []

Constraints:

    0 <= The length of the each list <= 100.
    -100 <= Node.val <= 100

 */

 /*
 Recursive Solution
 Time & Space Complexity: O(n + m) {Where n is the length of list1 and m is the length of list2}

 Merging two sorted linked lists recursively works by choosing the smaller head node of the two lists,
 meaning that the smaller value should appear first in the merged list.

 If one list is empty, return the other list; merging is complete at this point, really.

 Compare the head values of list1 and list2.
 If "list1.val <= list2.val":
    Set "list1.next" to the merged result of the remaining nodes.
    Return "list1" as the current head.

Otherwise:
    Set "list2.next" to the merged result of the remaining nodes.
    Return "list2" as the current head.

Recursion continues until both lists are fully merged/ 

 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}