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
 Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

Example 1:

Input: head = [0,1,2,3]

Output: [3,2,1,0]

Example 2:

Input: head = []

Output: []

Constraints:

    0 <= The length of the list <= 1000.
    -1000 <= Node.val <= 1000
 */

 /*
 Iteration Solution
 Time Complexity: O(n)
 Space Complexity: O(1)

 This uses three pointers for assignment (ListNode variables of prev, curr, and temp). 
 When "curr" becomes null, our list is fully reversed,
 and "prev" points to the new head.

 Again, another one that I will have to come back to to further let sink in due to the moving pointers
 and their assignments. Not recursion bad, but understanding the logical flow of how it is all working together...
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
